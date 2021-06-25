package com.juserdirs;

import io.github.g00fy2.versioncompare.Version;
import oshi.PlatformEnum;
import oshi.SystemInfo;

class OsInfo {

    private OsInfo() {
    }

    public static boolean isWindows7OrLater() {
        return SystemInfo.getCurrentPlatform() == PlatformEnum.WINDOWS &&
                new Version(System.getProperty("os.version")).isAtLeast("6.1");
    }
}
