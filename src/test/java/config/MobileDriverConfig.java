package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
        // "file:./src/test/resources/config/emulation.properties"
})
public interface MobileDriverConfig extends Config {
    @Key("remoteUrl")
    String getRemoteURL();

    @Key("user")
    String getUser();

    @Key("password")
    String getPassword();

    @Key("app")
    String getApp();

    @Key("device")
    String getDevice();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();

    @Key("osVersion")
    String getOsVersion();

    @Key("DeviceName")
    String getDeviceName();

    @Key("deviceUrl")
    String getDeviceUrl();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();

    @Key("appPath")
    String getAppPath();

    @Key("appUrl")
    String getAppUrl();
}