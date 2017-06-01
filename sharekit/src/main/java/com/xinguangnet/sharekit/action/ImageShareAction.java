package com.xinguangnet.sharekit.action;

import com.xinguangnet.sharekit.performer.ISharePerformer;
import com.xinguangnet.sharekit.callback.ShareResultCallback;
import com.xinguangnet.sharekit.callback.ShareStatusCallback;
import com.xinguangnet.sharekit.performer.WBSharePerformerImpl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;

/**
 * 图片分享操作
 * Created by Boqin on 2017/5/24.
 * Modified by Boqin
 *
 * @Version
 */
public class ImageShareAction extends BaseShareAction {


//    "imageurl");//网络图片
//    file);//本地文件
//    R.drawable.xxx);//资源文件
//    bitmap);//bitmap文件
//    byte[]);//字节流
    /** 标题 */
    private String mTitle;
    /** 内容 */
    private String mContent;
    /** 链接 */
    private String mUrl;
//    /** 图片 */
//    private String mImage;
//    /** 图片 */
//    private int mDrawable;
    /** 缩略图 */
    private String mThumb;

    private Bitmap mBitmap;

    /** 执行类 */
    private ISharePerformer mSharePerformer;

    private ImageShareAction(String title, String content, String url, Bitmap bitmap, String thumb, ShareStatusCallback shareStatusCallback,
            ShareResultCallback shareResultCallback) {
        super(shareStatusCallback, shareResultCallback);
        mTitle = title;
        mThumb = thumb;
        mBitmap = bitmap;
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
//        mBitmap = BitmapFactory.decodeResource(activity.getResources(), mDrawable);
        mSharePerformer = new WBSharePerformerImpl(activity, mShareStatusCallback, mShareResultCallback);
        mSharePerformer.shareTo(this);
    }

    @Override
    protected ISharePerformer getSharePerformer() {
        return mSharePerformer;
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

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public void setBitmap(Bitmap bitmap){
        mBitmap = bitmap;
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
        /** 链接 */
        private String mUrl;
        /** 缩略图 */
        private String mThumb;

        private Bitmap mBitmap;

        private ShareStatusCallback mShareStatusCallback;

        private ShareResultCallback mShareResultCallback;

        public Builder() {

        }

        public Builder setTitle(String title) {
            mTitle = title;
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
            return new ImageShareAction(mTitle, mContent, mUrl, mBitmap, mThumb, mShareStatusCallback, mShareResultCallback);
        }

        public Builder setShareStatusCallback(ShareStatusCallback shareStatusCallback) {
            mShareStatusCallback = shareStatusCallback;
            return this;
        }

        public Builder setUrl(String url) {
            mUrl = url;
            return this;
        }

        public Builder setBitmap(Bitmap bitmap) {
            mBitmap = bitmap;
            return this;
        }
    }
}
