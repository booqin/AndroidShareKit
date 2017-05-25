package com.xinguangnet.sharekit;

import com.xinguangnet.sharekit.impl.ImageShareWBPerformerImpl;

import android.app.Activity;
import android.text.TextUtils;

/**
 * 图片分享操作
 * Created by Boqin on 2017/5/24.
 * Modified by Boqin
 * @Version
 */
public class ImageShareAction implements ISharePerformer{

    /** 标题 */
    private String mTitle;
    /** 内容 */
    private String mContent;
    /** 图片 */
    private String mImage;
    /** 缩略图 */
    private String mThumb;

    private ImageShareAction(String title, String content, String image, String thumb){
        mTitle = title;
        mImage = image;
        mThumb = thumb;
        mContent = content;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean isShowTitle(){
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

    @Override
    public void showToWX(Activity activity) {

    }

    @Override
    public void showToWXCircle(Activity activity) {

    }

    @Override
    public void showToWB(Activity activity) {
        IShareWBPerformer imageShareWBPerformer = new ImageShareWBPerformerImpl(activity);
        imageShareWBPerformer.shareToWB(this);
    }

    /**
     * 构建者
     * @description: Created by Boqin on 2017/5/25 10:37
     */
    public static class Builder{
        /** 标题 */
        private String mTitle;
        /** 内容 */
        private String mContent;
        /** 图片 */
        private String mImage;
        /** 缩略图 */
        private String mThumb;

        public Builder(){

        }

        public Builder setTitle(String title){
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


        public ImageShareAction build(){
            return new ImageShareAction(mTitle, mContent, mImage, mThumb);
        }
    }
}
