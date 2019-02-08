package com.owncloud.android.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;

import com.owncloud.android.BuildConfig;

public final class PowerUtils {

    private PowerUtils() {
        // utility class -> private constructor
    }

    /**
     * Checks if device is in power save mode. For older devices that do not support this API, returns false.
     * @return true if it is, false otherwise.
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static boolean isPowerSaveMode(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);

            if (powerManager == null) {
                return false;
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (powerManager.isPowerSaveMode()) {
                    return !powerManager.isIgnoringBatteryOptimizations(BuildConfig.APPLICATION_ID);
                } else {
                    return false;
                }
            } else {
                return powerManager.isPowerSaveMode();
            }
        }

        // For older versions, we just say that device is not in power save mode
        return false;
    }
}
