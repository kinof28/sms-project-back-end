package com.smsProject.SmsProject.services;

import com.smsProject.SmsProject.configuration.TwilioConfiguration;
import com.smsProject.SmsProject.requests.MessageRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class MessageService {
    private  TwilioConfiguration twilioConfiguration;
    private static final Logger LOGGER= LoggerFactory.getLogger(MessageService.class);
    public boolean send(MessageRequest request){
        if(this.isPhoneNumberValide(request.getTo())){
            LOGGER.info("to :{} message : {} ",request.getTo(),request.getMessage());
            Message.creator(
                    new PhoneNumber(request.getTo()),
                    new PhoneNumber(this.twilioConfiguration.getTrialNumber()),
                    request.getMessage()
            ).create();
            return true;
        }else return false;
    }
    public boolean isPhoneNumberValide(String phoneNumber){
        return true;
    }
}
