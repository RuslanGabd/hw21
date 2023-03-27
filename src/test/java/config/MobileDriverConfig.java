package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:./src/test/resources/config/config.properties"
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
}