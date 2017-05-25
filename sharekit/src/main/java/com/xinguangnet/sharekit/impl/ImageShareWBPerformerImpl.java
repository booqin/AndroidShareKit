package com.xinguangnet.sharekit.impl;

import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.share.WbShareHandler;
import com.xinguangnet.sharekit.IShareWBPerformer;
import com.xinguangnet.sharekit.ImageShareAction;
import com.xinguangnet.sharekit.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

/**
 * TODO
 * Created by Boqin on 2017/5/25.
 * Modified by Boqin
 *
 * @Version
 */
public class ImageShareWBPerformerImpl implements IShareWBPerformer {

    private Activity mActivity;

    private WbShareHandler mShareHandler;

    public ImageShareWBPerformerImpl(Activity activity){
        mActivity = activity;
        mShareHandler = new WbShareHandler(mActivity);
        mShareHandler.registerApp();
    }

    @Override
    public void shareToWB(ImageShareAction imageShareAction) {
        WeiboMultiMessage wbMessage = new WeiboMultiMessage();
        if (imageShareAction.isShowTitle()) {
            wbMessage.textObject = getTextObj(imageShareAction.getTitle(), imageShareAction.getTitle(), "");
        }
        wbMessage.imageObject = getImageObj();
        mShareHandler.shareMessage(wbMessage, true);
    }


    /**
     * 创建文本消息对象。
     * @return 文本消息对象。
     */
    private TextObject getTextObj(String title, String content, String url) {
        TextObject textObject = new TextObject();
        if (TextUtils.isEmpty(title)) {
            textObject.title = title;
        }
        if (TextUtils.isEmpty(content)) {
            textObject.text = content;
        }
        if (TextUtils.isEmpty(url)) {
            textObject.actionUrl = url;
        }
        return textObject;
    }


    /**
     * 创建图片消息对象。
     * @return 图片消息对象。
     */
    private ImageObject getImageObj() {
        ImageObject imageObject = new ImageObject();
        Bitmap bitmap = BitmapFactory.decodeResource(mActivity.getResources(), R.drawable.test);
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

}
