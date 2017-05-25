package com.xinguangnet.sharekit;

import android.content.Intent;

/**
 * 微博分享接口
 * Created by Boqin on 2017/5/25.
 * Modified by Boqin
 *
 * @Version
 */
public interface ISharePerformer {

    /**
     * 分享到微博
     * @param imageShareAction
     */
    void shareTo(ImageShareAction imageShareAction);

    void doResultIntent(Intent intent);

}
