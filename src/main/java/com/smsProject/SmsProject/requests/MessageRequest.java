package com.smsProject.SmsProject.requests;

import lombok.Data;

@Data
public class MessageRequest {
    private String to;
    private String message;
}
