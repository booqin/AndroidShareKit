package com.xinguangnet.sharekit.callback;

/**
 * 分享结果回调
 * Created by Boqin on 2017/5/25.
 * Modified by Boqin
 *
 * @Version
 */
public interface ShareResultCallback {
    void onShareSuccess();
    void onShareFail();
    void onShareCancel();
}
