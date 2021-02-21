package com.bulo.springit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("springit")

public class SpringitProperties {


    private String welcomeMsg = "Hello bulo";

    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }
}
