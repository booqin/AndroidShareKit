package com.xinguangnet.sharekit.action;

import com.xinguangnet.sharekit.performer.ISharePerformer;
import com.xinguangnet.sharekit.callback.ShareResultCallback;
import com.xinguangnet.sharekit.callback.ShareStatusCallback;

import android.content.Intent;

/**
 * TODO
 * Created by Boqin on 2017/5/26.
 * Modified by Boqin
 *
 * @Version
 */
public abstract class BaseShareAction implements IShareAction{

    /** 状态回调 */
    protected ShareStatusCallback mShareStatusCallback;
    /** 结果回调 */
    protected ShareResultCallback mShareResultCallback;

    protected BaseShareAction(ShareStatusCallback shareStatusCallback,
            ShareResultCallback shareResultCallback){
        mShareStatusCallback = shareStatusCallback;
        mShareResultCallback = shareResultCallback;
    }

    @Override
    public void doResultIntent(Intent intent) {
        if (getSharePerformer()!=null) {
            getSharePerformer().doResultIntent(intent);
        }
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

    protected abstract ISharePerformer getSharePerformer();
}
