package com.xinguangnet.sharekit.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.xinguangnet.sharekit.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;

/**
 * 图片工具类测试
 * Created by Boqin on 2017/6/12.
 * Modified by Boqin
 *
 * @Version
 */
public class ImageUtilTest {

    private Context mContext;

    @Before
    public void setUp() throws Exception {
        mContext = InstrumentationRegistry.getTargetContext();

    }

    @Test
    public void CustomSchemeInUriInputRes(){
        Uri uri = ImageUtil.setUri(ImageUtil.SCHEME.RES, ""+R.drawable.test);
        assertThat(uri.getScheme(), is(ImageUtil.SCHEME.RES));
        assertThat(ImageUtil.getPathWithoutSlash(uri), is(""+R.drawable.test));
    }

    @Test
    public void testUriToBMPInputRes(){
        Uri uri = ImageUtil.setUri(ImageUtil.SCHEME.RES, ""+R.drawable.test);
        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.test);
        assertThat(bitmap.sameAs(ImageUtil.uriToBMP(mContext, uri)), is(true));
    }

}