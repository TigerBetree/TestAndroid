package com.tiger.test.utils;

import android.content.Context;
import android.util.Log;

import com.github.gzuliyujiang.oaid.DeviceID;
import com.github.gzuliyujiang.oaid.DeviceIdentifier;
import com.github.gzuliyujiang.oaid.IGetter;

public class DeviceUtil {

    public static void getDeviceIds(Context context) {
        // 获取IMEI，只支持Android 10之前的系统，需要READ_PHONE_STATE权限，可能为空
        String imei = DeviceIdentifier.getIMEI(context);
        Log.d("DeviceIds", "imei : " + imei);

        // 获取安卓ID，可能为空
        String androidId = DeviceIdentifier.getAndroidID(context);
        Log.d("DeviceIds", "androidId : " + androidId);

        // 获取数字版权管理ID，可能为空
        String widevineId = DeviceIdentifier.getWidevineID();
        Log.d("DeviceIds", "widevineId : " + widevineId);

        // 获取伪造ID，根据硬件信息生成，不会为空，有大概率会重复
        String pseudoId = DeviceIdentifier.getPseudoID();
        Log.d("DeviceIds", "pseudoId : " + pseudoId);

        // 获取GUID，随机生成，不会为空
        String guid = DeviceIdentifier.getGUID(context);
        Log.d("DeviceIds", "guid : " + guid);

        // 是否支持OAID/AAID
        boolean supportOAID = DeviceID.supportedOAID(context);
        Log.d("DeviceIds", "supportOAID : " + supportOAID);

        // 获取OAID/AAID，同步调用
        String oaid = DeviceIdentifier.getOAID(context);
        Log.d("DeviceIds", "oaid : " + oaid);

        // 获取OAID/AAID，异步回调
        DeviceID.getOAID(context, new IGetter() {
            @Override
            public void onOAIDGetComplete(String result) {
                // 不同厂商的OAID/AAID格式是不一样的，可进行MD5、SHA1之类的哈希运算统一

                Log.d("DeviceIds", "oaid result : " + result);
            }

            @Override
            public void onOAIDGetError(Exception error) {
                // 获取OAID/AAID失败

                Log.d("DeviceIds", "oaid result : " + error.toString());
            }
        });
    }
}
