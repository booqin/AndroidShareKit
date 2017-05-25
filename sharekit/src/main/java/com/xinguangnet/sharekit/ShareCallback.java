package com.xinguangnet.sharekit;

/**
 * 分享接口
 * Created by Boqin on 2017/5/25.
 * Modified by Boqin
 *
 * @Version
 */
public interface ShareCallback {

    void onStart();

    void onShareSuccess();
    void onShareFail();
    void onShareCancel();
}
