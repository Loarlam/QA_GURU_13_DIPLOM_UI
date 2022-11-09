package ru.tele2.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends Config {
    @Key("remoteLink")
    String remoteLink();

    @Key("login")
    String login();

    @Key("password")
    String password();

    @DefaultValue("0x0")
    @Key("position")
    String position();

    @DefaultValue("chrome")
    @Key("browser")
    String browser();

    @DefaultValue("100")
    @Key("version")
    String version();

    @DefaultValue("1920x1080")
    @Key("resolution")
    String resolution();
}