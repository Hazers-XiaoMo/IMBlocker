package io.github.reserveword.imblocker;

import com.sun.jna.Platform;

public class IMManager {

    public sealed interface PlatformIMManager permits IMManagerMac, IMManagerWindows {

        PlatformIMManager INSTANCE = getInstance();

        private static PlatformIMManager getInstance() {
            if (Platform.isWindows())
                return new IMManagerWindows();
            if (Platform.isMac())
                return new IMManagerMac();
            throw new UnsupportedOperationException("Unsupported platform");
        }


        void makeOn();

        void makeOff();

        void setState(boolean on);

        void syncState();

        boolean getState();

    }

    public static void makeOn() {
        IMManager.PlatformIMManager.INSTANCE.makeOn();
    }

    public static void makeOff() {
        IMManager.PlatformIMManager.INSTANCE.makeOff();
    }

    public static void setState(boolean on) {
        IMManager.PlatformIMManager.INSTANCE.setState(on);
    }

    public static void syncState() {
        IMManager.PlatformIMManager.INSTANCE.syncState();
    }

    boolean getState() {
        return IMManager.PlatformIMManager.INSTANCE.getState();
    }
}
