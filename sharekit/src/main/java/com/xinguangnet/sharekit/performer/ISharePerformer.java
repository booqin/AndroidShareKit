package com.xinguangnet.sharekit.performer;

import com.xinguangnet.sharekit.action.ImageShareAction;
import com.xinguangnet.sharekit.action.TextShareAction;

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

    void shareTo(TextShareAction textShareAction);

    void doResultIntent(Intent intent);

}
