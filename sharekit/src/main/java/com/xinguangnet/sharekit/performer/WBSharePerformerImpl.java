package com.xinguangnet.sharekit.performer;

import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.WbShareHandler;
import com.xinguangnet.sharekit.action.ImageShareAction;
import com.xinguangnet.sharekit.action.TextShareAction;
import com.xinguangnet.sharekit.callback.ShareResultCallback;
import com.xinguangnet.sharekit.callback.ShareStatusCallback;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;

/**
 * 图文微博分享实现类
 * Created by Boqin on 2017/5/25.
 * Modified by Boqin
 *
 * @Version
 */
public class WBSharePerformerImpl implements ISharePerformer, WbShareCallback{

    private Activity mActivity;

    private WbShareHandler mShareHandler;

    private ShareStatusCallback mShareStatusCallback;

    private ShareResultCallback mShareResultCallback;

    public WBSharePerformerImpl(Activity activity, ShareStatusCallback shareStatusCallback, ShareResultCallback shareResultCallback){
        mActivity = activity;
        mShareHandler = new WbShareHandler(mActivity);
        mShareHandler.registerApp();
        mShareStatusCallback = shareStatusCallback;
        mShareResultCallback = shareResultCallback;
    }

    @Override
    public void shareTo(ImageShareAction imageShareAction) {
        if (mShareStatusCallback !=null) {
            mShareStatusCallback.onStart();
        }
        WeiboMultiMessage wbMessage = new WeiboMultiMessage();
        if (imageShareAction.isShowTitle()) {
            wbMessage.textObject = getTextObj(imageShareAction.getTitle(), imageShareAction.getContent(), imageShareAction.getUrl());
        }
        wbMessage.imageObject = getImageObj(imageShareAction.getBitmap());
        mShareHandler.shareMessage(wbMessage, true);
    }

    @Override
    public void shareTo(TextShareAction textShareAction) {
        if (mShareStatusCallback !=null) {
            mShareStatusCallback.onStart();
        }
        WeiboMultiMessage wbMessage = new WeiboMultiMessage();
        wbMessage.textObject = getTextObj(textShareAction.getTitle(), textShareAction.getContent(), textShareAction.getUrl());
        mShareHandler.shareMessage(wbMessage, true);
    }

    @Override
    public void doResultIntent(Intent intent) {
        mShareHandler.doResultIntent(intent, this);
    }

    @Override
    public void onWbShareSuccess() {
        if (mShareResultCallback !=null) {
            mShareResultCallback.onShareSuccess();
        }
        if (mShareStatusCallback !=null) {
            mShareStatusCallback.onFinish();
        }
    }

    @Override
    public void onWbShareCancel() {
        if (mShareResultCallback !=null) {
            mShareResultCallback.onShareCancel();
        }
        if (mShareStatusCallback !=null) {
            mShareStatusCallback.onFinish();
        }
    }

    @Override
    public void onWbShareFail() {
        if (mShareResultCallback !=null) {
            mShareResultCallback.onShareFail();
        }
        if (mShareStatusCallback !=null) {
            mShareStatusCallback.onFinish();
        }
    }

    /**
     * 创建文本消息对象。
     * @return 文本消息对象。
     */
    private TextObject getTextObj(String title, String content, String url) {
        TextObject textObject = new TextObject();
        if (!TextUtils.isEmpty(title)) {
            textObject.title = title;
        }
        if (!TextUtils.isEmpty(content)) {
            textObject.text = content;
        }
        if (!TextUtils.isEmpty(url)) {
            textObject.actionUrl = url;
        }
        return textObject;
    }


    /**
     * 创建图片消息对象。
     * @return 图片消息对象。
     */
    private ImageObject getImageObj(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

}
