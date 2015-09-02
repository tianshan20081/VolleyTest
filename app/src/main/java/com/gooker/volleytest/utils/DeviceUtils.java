package com.gooker.volleytest.utils;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;

/**
 * 获取 手机的一些特征值
 * Created by mz on 15/9/2.
 */
public class DeviceUtils {
	/**
	 * 这是Android系统为开发者提供的用于标识手机设备的串号，也是各种方法中普适性较高的，可以说几乎所有的设备都可以返回这个串号，并且唯一性良好。
	 * <p/>
	 * 它会根据不同的手机设备返回IMEI，MEID或者ESN码，但在使用的过程中有以下问题：
	 * <p/>
	 * 非手机设备：最开始搭载Android系统都手机设备，而现在也出现了非手机设备：如平板电脑、电子书、电视、音乐播放器等。这些设备没有通话的硬件功能，系统中也就没有TELEPHONY_SERVICE，自然也就无法通过上面的方法获得DEVICE_ID。
	 * 权限问题：获取DEVICE_ID需要READ_PHONE_STATE权限，如果只是为了获取DEVICE_ID而没有用到其他的通话功能，申请这个权限一来大才小用，二来部分用户会怀疑软件的安全性。
	 * 厂商定制系统中的Bug：少数手机设备上，由于该实现有漏洞，会返回垃圾，如:zeros或者asterisks
	 *
	 * @param context
	 *
	 * @return
	 */
	public static String getDeviceId(Context context) {
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		String DEVICE_ID = tm.getDeviceId();
		return DEVICE_ID;
	}

	/**
	 * 可以使用手机Wifi或蓝牙的MAC地址作为设备标识，但是并不推荐这么做，原因有以下两点：
	 * <p/>
	 * 硬件限制：并不是所有的设备都有Wifi和蓝牙硬件，硬件不存在自然也就得不到这一信息。
	 * 获取的限制：如果Wifi没有打开过，是无法获取其Mac地址的；而蓝牙是只有在打开的时候才能获取到其Mac地址。
	 * <p/>
	 * 获取Wifi Mac地址：
	 * <p/>
	 * 获取蓝牙 Mac地址：
	 *
	 * @param context
	 *
	 * @return
	 */
	public static String getMacAddress(Context context) {
		return "mac";
	}

	/**
	 * Sim Serial Number
	 * 装有SIM卡的设备，可以通过下面的方法获取到Sim Serial Number：
	 * 注意：对于CDMA设备，返回的是一个空值！
	 *
	 * @param context
	 *
	 * @return
	 */
	public static String getSSM(Context context) {


		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		String SimSerialNumber = tm.getSimSerialNumber();
		return SimSerialNumber;

	}

	/**
	 * 在设备首次启动时，系统会随机生成一个64位的数字，并把这个数字以16进制字符串的形式保存下来，这个16进制的字符串就是ANDROID_ID，当设备被wipe后该值会被重置。可以通过下面的方法获取：
	 * <p/>
	 * ANDROID_ID可以作为设备标识，但需要注意：
	 * <p/>
	 * 厂商定制系统的Bug：不同的设备可能会产生相同的ANDROID_ID：9774d56d682e549c。
	 * 厂商定制系统的Bug：有些设备返回的值为null。
	 * 设备差异：对于CDMA设备，ANDROID_ID和TelephonyManager.getDeviceId() 返回相同的值。
	 *
	 * @param context
	 *
	 * @return
	 */
	public static String getAndroidId(Context context) {
		String ANDROID_ID = Settings.System.getString(context.getContentResolver(), Settings.System.ANDROID_ID);
		return ANDROID_ID;
	}

	/**
	 * Serial Number
	 * <p/>
	 * <p/>
	 * Android系统2.3版本以上可以通过下面的方法得到Serial Number，且非手机设备也可以通过该接口获取。
	 *
	 * @param context
	 *
	 * @return
	 */
	public static String getSerialNumber(Context context) {
		String SerialNumber = android.os.Build.SERIAL;
		return SerialNumber;
	}
}
