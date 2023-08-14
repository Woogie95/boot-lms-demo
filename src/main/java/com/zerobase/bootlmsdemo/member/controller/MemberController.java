package com.zerobase.bootlmsdemo.member.controller;

import com.zerobase.bootlmsdemo.member.model.MemberInput;
import com.zerobase.bootlmsdemo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/member/register")
    public String register() {

        return "member/register";
    }

    @PostMapping("/member/register")
    public String registerSubmit(Model model, HttpServletRequest request, MemberInput parameter) {

        boolean result = memberService.register(parameter);
        model.addAttribute("result", result);
        System.out.println(result + "??????????????????");

        return "member/register_complete";
    }
}