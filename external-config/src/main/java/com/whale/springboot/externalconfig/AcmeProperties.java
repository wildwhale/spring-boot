package com.whale.springboot.externalconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "acme")
public class AcmeProperties {

    private boolean enabled;
    private String remoteAddress;
    private final Security security = new Security();

    @Data
    public static class Security {
        private String username;
        private String password;
        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));
    }
}