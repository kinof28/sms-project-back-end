package com.smsProject.SmsProject.configuration;

import com.twilio.Twilio;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
//@AllArgsConstructor
@Configuration
public class TwilioInitializer {
    private TwilioConfiguration configuration;
    private final static Logger LOGGER= LoggerFactory.getLogger(TwilioInitializer.class);
    @Autowired
    public TwilioInitializer(TwilioConfiguration configuration) {
        this.configuration = configuration;
        Twilio.init(configuration.getAccountSid(),configuration.getAuthToken());
//        LOGGER.info("Twilio initialized with Sid = {} and auth= {}",this.configuration.getAccountSid(),this.configuration.getAuthToken());
    }
}
