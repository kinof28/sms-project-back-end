package com.smsProject.SmsProject.controller;

import com.smsProject.SmsProject.requests.MessageRequest;
import com.smsProject.SmsProject.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class SmsController {
    MessageService messageService;
    @PostMapping("/send/")
    public String sendMessage(@RequestBody MessageRequest request){
        if(this.messageService.send(request))return "send";
        else return "error";
    }
}
