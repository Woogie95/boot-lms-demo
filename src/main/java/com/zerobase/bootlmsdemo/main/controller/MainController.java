package com.zerobase.bootlmsdemo.main.controller;

import com.zerobase.bootlmsdemo.components.MailComponents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponents mailComponents;

    @GetMapping("/")
    public String index() {
        String email = "asdqw18@gmail.com";
        String subject = "Lecture";
        String text = "메일 테스트";

        mailComponents.sendMail(email, subject, text);
        return "index";
    }
}
