package com.tiger.test.utils;

import android.util.Log;

public class LogUtil {
   public static final String TAG = "Tiger";

   public static void logd(String msg){
      Log.d(TAG, msg);
   }
}
