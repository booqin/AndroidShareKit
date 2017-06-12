package com.xinguangnet.sharekit.action;

import com.xinguangnet.sharekit.performer.ISharePerformer;
import com.xinguangnet.sharekit.callback.ShareResultCallback;
import com.xinguangnet.sharekit.callback.ShareStatusCallback;
import com.xinguangnet.sharekit.performer.WBSharePerformerImpl;
import com.xinguangnet.sharekit.performer.WXSessionSharePerformerImpl;

import android.app.Activity;

/**
 * 文本分享类
 * Created by Boqin on 2017/5/26.
 * Modified by Boqin
 *
 * @Version
 */
public class TextShareAction extends BaseShareAction {

    /** 标题 */
    private String mTitle;
    /** 内容 */
    private String mContent;

    private String mUrl;

    private ISharePerformer mSharePerformer;

    private TextShareAction(String title, String content, String url, ShareStatusCallback shareStatusCallback,
            ShareResultCallback shareResultCallback) {
        super(shareStatusCallback, shareResultCallback);
        mTitle = title;
        mContent = content;
        mUrl = url;
    }

    @Override
    public void showToWX(Activity activity) {
        mSharePerformer = WXSessionSharePerformerImpl.getInstance(mShareStatusCallback, mShareResultCallback);
        mSharePerformer.shareTo(this);
    }

    @Override
    public void showToWXCircle(Activity activity) {

    }

    @Override
    public void showToWB(Activity activity) {
        mSharePerformer = new WBSharePerformerImpl(activity, mShareStatusCallback, mShareResultCallback);
        mSharePerformer.shareTo(this);
    }

    @Override
    public void onDestroy() {

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

        private ShareStatusCallback mShareStatusCallback;

        private ShareResultCallback mShareResultCallback;

        public Builder() {

        }

        public TextShareAction.Builder setTitle(String title) {
            mTitle = title;
            return this;
        }

        public TextShareAction.Builder setContent(String content) {
            mContent = content;
            return this;
        }

        public TextShareAction.Builder setShareResultCallback(ShareResultCallback shareResultCallback) {
            mShareResultCallback = shareResultCallback;
            return this;
        }

        public TextShareAction build() {
            return new TextShareAction(mTitle, mContent, mUrl, mShareStatusCallback, mShareResultCallback);
        }

        public TextShareAction.Builder setShareStatusCallback(ShareStatusCallback shareStatusCallback) {
            mShareStatusCallback = shareStatusCallback;
            return this;
        }

        public TextShareAction.Builder setUrl(String url) {
            mUrl = url;
            return this;
        }
    }
}
