package config;

import org.aeonbits.owner.Config;

@Config.Sources({
       "classpath:config/${env}.properties"
      })
public interface MobileDriverConfig extends Config {
    @Key("remoteUrl")
    String getRemoteURL();

    @Key("user")
    String getUser();

    @Key("password")
    String getPassword();

    @Key("app")
    @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
    String app();

    @Key("deviceName")
    String getDeviceName();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();


    @Key("osVersion")
    String getOsVersion();

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