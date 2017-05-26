package com.xinguangnet.sharekit;

import com.xinguangnet.sharekit.callback.ShareResultCallback;
import com.xinguangnet.sharekit.callback.ShareStatusCallback;
import com.xinguangnet.sharekit.impl.ImageShareWBPerformerImpl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

/**
 * 图片分享操作
 * Created by Boqin on 2017/5/24.
 * Modified by Boqin
 *
 * @Version
 */
public class ImageShareAction implements IShareAction {

    /** 标题 */
    private String mTitle;
    /** 内容 */
    private String mContent;
    /** 图片 */
    private String mImage;
    /** 缩略图 */
    private String mThumb;
    /** 状态回调 */
    private ShareStatusCallback mShareStatusCallback;
    /** 结果回调 */
    private ShareResultCallback mShareResultCallback;
    /** 执行类 */
    private ISharePerformer mSharePerformer;

    private ImageShareAction(String title, String content, String image, String thumb, ShareStatusCallback shareStatusCallback,
            ShareResultCallback shareResultCallback) {
        mTitle = title;
        mImage = image;
        mThumb = thumb;
        mContent = content;
        mShareStatusCallback = shareStatusCallback;
        mShareResultCallback = shareResultCallback;
    }

    @Override
    public void showToWX(Activity activity) {

    }

    @Override
    public void showToWXCircle(Activity activity) {

    }

    @Override
    public void showToWB(Activity activity) {
        mSharePerformer = new ImageShareWBPerformerImpl(activity, mShareStatusCallback, mShareResultCallback);
        mSharePerformer.shareTo(this);
    }

    @Override
    public void doResultIntent(Intent intent) {
        mSharePerformer.doResultIntent(intent);
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean isShowTitle() {
        return !TextUtils.isEmpty(mTitle);
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getThumb() {
        return mThumb;
    }

    public void setThumb(String thumb) {
        mThumb = thumb;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public ShareResultCallback getShareResultCallback() {
        return mShareResultCallback;
    }

    public void setShareResultCallback(ShareResultCallback shareResultCallback) {
        mShareResultCallback = shareResultCallback;
    }

    public void setShareStatusCallback(ShareStatusCallback shareStatusCallback) {
        mShareStatusCallback = shareStatusCallback;
    }

    /**
     * 构建者
     *
     * @description: Created by Boqin on 2017/5/25 10:37
     */
    public static class Builder {
        /** 标题 */
        private String mTitle;
        /** 内容 */
        private String mContent;
        /** 图片 */
        private String mImage;
        /** 缩略图 */
        private String mThumb;

        private ShareStatusCallback mShareStatusCallback;

        private ShareResultCallback mShareResultCallback;

        public Builder() {

        }

        public Builder setTitle(String title) {
            mTitle = title;
            return this;
        }

        public Builder setImage(String image) {
            mImage = image;
            return this;
        }

        public Builder setThumb(String thumb) {
            mThumb = thumb;
            return this;
        }

        public Builder setContent(String content) {
            mContent = content;
            return this;
        }

        public Builder setShareResultCallback(ShareResultCallback shareResultCallback) {
            mShareResultCallback = shareResultCallback;
            return this;
        }

        public ImageShareAction build() {
            return new ImageShareAction(mTitle, mContent, mImage, mThumb, mShareStatusCallback, mShareResultCallback);
        }

        public Builder setShareStatusCallback(ShareStatusCallback shareStatusCallback) {
            mShareStatusCallback = shareStatusCallback;
            return this;
        }
    }
}
