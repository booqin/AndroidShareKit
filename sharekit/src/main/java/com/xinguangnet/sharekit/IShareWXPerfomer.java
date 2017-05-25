package com.xinguangnet.sharekit;

/**
 * TODO
 * Created by Boqin on 2017/5/25.
 * Modified by Boqin
 *
 * @Version
 */
public interface IShareWXPerfomer {


    /**
     * 分享到微信
     * @param imageShareAction
     */
    void shareToWX(ImageShareAction imageShareAction);
    /**
     * 分享到朋友圈
     * @param imageShareAction
     */
    void shareToWXCircle(ImageShareAction imageShareAction);

}
