package com.xinguangnet.sharekit.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URI;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

/**
 * TODO
 * Created by Boqin on 2017/6/9.
 * Modified by Boqin
 *
 * @Version
 */
public class ImageUtil {


    public static byte[] bmpToByteArray(final Bitmap bmp, final boolean needRecycle) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, output);
        if (needRecycle) {
            bmp.recycle();
        }

        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Bitmap uriToBMP(Context context, Uri uri){
        Bitmap bitmap = null;
        if(uri==null){
            return null;
        }
        try {
            if (uri.getScheme().equals(SCHEME.RES)) {
                bitmap = BitmapFactory.decodeResource(context.getResources(), Integer.valueOf(uri.getPath()));
            }else if (uri.getScheme().equals(SCHEME.FILE)){
                bitmap = BitmapFactory.decodeFile(uri.getPath());
            }
        }catch (Exception e){

        }
        return bitmap;
    }

    public static Uri setUri(String scheme, String path){
        return new Uri.Builder().scheme(scheme).path(path).build();
    }

    public interface SCHEME{
        String RES = "res";
        String FILE = "file";
    }

}
