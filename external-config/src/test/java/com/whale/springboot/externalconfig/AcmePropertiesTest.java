package com.whale.springboot.externalconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@ContextConfiguration(classes = AcmeProperties.class, initializers = ConfigFileApplicationContextInitializer.class)
public class AcmePropertiesTest {

    @Autowired
    private AcmeProperties properties;

    @Test
    public void givenDefaultTPS_whenVariableRetrieved_thenDefaultFileReturned() {
        assertThat("192.168.1.1",  is(this.properties.getRemoteAddress()));
        assertThat("admin",  is(this.properties.getSecurity().getUsername()));
        assertThat(Arrays.asList("USER", "ADMIN"),  is(this.properties.getSecurity().getRoles()));
    }
}