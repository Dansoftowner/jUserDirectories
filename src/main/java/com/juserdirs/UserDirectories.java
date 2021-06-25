package com.juserdirs;

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinReg;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public abstract class UserDirectories {

    private static UserDirectories instance;

    private UserDirectories() {
    }

    public String userDirectoryPath() {
        return System.getProperty("user.home");
    }

    @Nullable
    public abstract String documentsDirectoryPath();

    public String documentsDirectoryPath(String orElse) {
        return Optional.ofNullable(documentsDirectoryPath()).orElse(orElse);
    }

    @Nullable
    public abstract String picturesDirectoryPath();

    public String picturesDirectoryPath(String orElse) {
        return Optional.ofNullable(picturesDirectoryPath()).orElse(orElse);
    }

    @Nullable
    public abstract String videosDirectoryPath();

    public String videosDirectoryPath(String orElse) {
        return Optional.ofNullable(videosDirectoryPath()).orElse(orElse);
    }

    @Nullable
    public abstract String musicDirectoryPath();

    public String musicDirectoryPath(String orElse) {
        return Optional.ofNullable(musicDirectoryPath()).orElse(orElse);
    }

    @Nullable
    public abstract String downloadsDirectoryPath();

    public String downloadsDirectoryPath(String orElse) {
        return Optional.ofNullable(downloadsDirectoryPath()).orElse(orElse);
    }

    @Nullable
    public abstract String desktopDirectoryPath();

    public String desktopDirectoryPath(String orElse) {
        return Optional.ofNullable(desktopDirectoryPath()).orElse(orElse);
    }

    public static synchronized UserDirectories get() {
        if (instance == null) {
            if (OsInfo.isWindows7OrLater()) {
                instance = new WindowsDirectories();
            } else {
                instance = new NoDirectories();
            }
        }
        return instance;
    }

    private static final class WindowsDirectories extends UserDirectories {

        private static final String REGISTRY_PATH = "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Explorer\\Shell Folders";

        private static final String DOWNLOADS_REGISTRY = "{374DE290-123F-4565-9164-39C4925E467B}";
        private static final String DESKTOP_REGISTRY = "Desktop";
        private static final String MUSIC_REGISTRY = "My Music";
        private static final String PICTURES_REGISTRY = "My Pictures";
        private static final String VIDEOS_REGISTRY = "My Video";
        private static final String DOCUMENTS_REGISTRY = "Personal";

        @Override
        public @Nullable String documentsDirectoryPath() {
            return getRegistryValue(DOCUMENTS_REGISTRY);
        }

        @Override
        public @Nullable String picturesDirectoryPath() {
            return getRegistryValue(PICTURES_REGISTRY);
        }

        @Override
        public @Nullable String videosDirectoryPath() {
            return getRegistryValue(VIDEOS_REGISTRY);
        }

        @Override
        public @Nullable String musicDirectoryPath() {
            return getRegistryValue(MUSIC_REGISTRY);
        }

        @Override
        public @Nullable String downloadsDirectoryPath() {
            return getRegistryValue(DOWNLOADS_REGISTRY);
        }

        @Override
        public @Nullable String desktopDirectoryPath() {
            return getRegistryValue(DESKTOP_REGISTRY);
        }

        private String getRegistryValue(String key) {
            if (Advapi32Util.registryValueExists(WinReg.HKEY_CURRENT_USER, REGISTRY_PATH, key)) {
                return Advapi32Util.registryGetStringValue(WinReg.HKEY_CURRENT_USER, REGISTRY_PATH, key);
            }
            return null;
        }
    }

    private static final class NoDirectories extends UserDirectories {
        @Override
        public @Nullable String documentsDirectoryPath() {
            return null;
        }

        @Override
        public @Nullable String picturesDirectoryPath() {
            return null;
        }

        @Override
        public @Nullable String videosDirectoryPath() {
            return null;
        }

        @Override
        public @Nullable String musicDirectoryPath() {
            return null;
        }

        @Override
        public @Nullable String downloadsDirectoryPath() {
            return null;
        }

        @Override
        public @Nullable String desktopDirectoryPath() {
            return null;
        }
    }

}
