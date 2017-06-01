package com.xinguangnet.sharekit.performer;

import java.io.ByteArrayOutputStream;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xinguangnet.sharekit.Constants;
import com.xinguangnet.sharekit.ShareKit;
import com.xinguangnet.sharekit.action.ImageShareAction;
import com.xinguangnet.sharekit.action.TextShareAction;
import com.xinguangnet.sharekit.callback.ShareResultCallback;
import com.xinguangnet.sharekit.callback.ShareStatusCallback;
import com.xinguangnet.sharekit.wxapi.WXEntryActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;

/**
 * 分享至微信
 * Created by Boqin on 2017/5/26.
 * Modified by Boqin
 *
 * @Version
 */
public class WXSessionSharePerformerImpl implements ISharePerformer, IWXAPIEventHandler {

    private static final int THUMB_SIZE = 150;

    private IWXAPI api;

    private ShareStatusCallback mShareStatusCallback;

    private ShareResultCallback mShareResultCallback;


    public WXSessionSharePerformerImpl(Activity activity, ShareStatusCallback shareStatusCallback, ShareResultCallback shareResultCallback) {
//        api = WXAPIFactory.createWXAPI(activity, ShareKit.WX_APP_ID);
//        api.registerApp(ShareKit.WX_APP_ID);
        api = ShareKit.api;
        mShareStatusCallback = shareStatusCallback;
        mShareResultCallback = shareResultCallback;
        WXEntryActivity.setEventHandler(this);
    }

    @Override
    public void shareTo(ImageShareAction imageShareAction) {
        SendMessageToWX.Req req = getBitmapToWX(imageShareAction);
        if (mShareStatusCallback!=null) {
            mShareStatusCallback.onStart();
        }
        api.sendReq(req);
    }

    @Override
    public void shareTo(TextShareAction textShareAction) {
        SendMessageToWX.Req req = getMessageToWX(textShareAction);
        if (mShareStatusCallback!=null) {
            mShareStatusCallback.onStart();
        }
        api.sendReq(req);
    }

    @Override
    public void doResultIntent(Intent intent) {

    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        if (mShareStatusCallback!=null) {
            mShareStatusCallback.onFinish();
        }
        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                if (mShareResultCallback!=null) {
                    mShareResultCallback.onShareSuccess();
                }
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                if (mShareResultCallback!=null) {
                    mShareResultCallback.onShareFail();
                }
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                if (mShareResultCallback!=null) {
                    mShareResultCallback.onShareFail();
                }
                break;
            case BaseResp.ErrCode.ERR_UNSUPPORT:
                if (mShareResultCallback!=null) {
                    mShareResultCallback.onShareFail();
                }
                break;
            default:
                if (mShareResultCallback!=null) {
                    mShareResultCallback.onShareFail();
                }
                break;
        }
    }

    private SendMessageToWX.Req getMessageToWX(TextShareAction textShareAction){

        WXTextObject textObject = new WXTextObject();
        textObject.text = textShareAction.getContent();

        WXMediaMessage wxMediaMessage = new WXMediaMessage();
        wxMediaMessage.mediaObject = textObject;
        wxMediaMessage.description = textShareAction.getContent();

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("text");
        req.message = wxMediaMessage;
        req.scene = SendMessageToWX.Req.WXSceneSession;

        return req;
    }

    private SendMessageToWX.Req getBitmapToWX(ImageShareAction imageShareAction){

        WXImageObject wxImageObject = new WXImageObject(imageShareAction.getBitmap());
        WXMediaMessage wxMediaMessage = new WXMediaMessage();
        wxMediaMessage.mediaObject = wxImageObject;

        Bitmap thumbmp = Bitmap.createScaledBitmap(imageShareAction.getBitmap(), THUMB_SIZE, THUMB_SIZE, true);

        wxMediaMessage.thumbData = bmpToByteArray(thumbmp, true);

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("img");
        req.message = wxMediaMessage;
        req.scene = SendMessageToWX.Req.WXSceneSession;

        return req;
    }

    private String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }



    public byte[] bmpToByteArray(final Bitmap bmp, final boolean needRecycle) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, output);
        if (needRecycle) {
            bmp.recycle();
        }

        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
