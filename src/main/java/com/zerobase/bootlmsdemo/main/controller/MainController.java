package com.zerobase.bootlmsdemo.main.controller;

import com.zerobase.bootlmsdemo.components.MailComponents;
import com.zerobase.bootlmsdemo.member.service.imlp.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponents mailComponents;
    private final MemberServiceImpl memberService;

    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {
        String userAgent = RequestUtils.getUserAgent(request);
        String clientsIp = RequestUtils.getClientIP(request);
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        log.info(userAgent);
        log.info(clientsIp);
        log.info(userId);
        if (userId != "anonymousUser") {
            loginHistoryService.saveLoginHistory(userId, clientsIp, userAgent);
            memberService.updateLastLogin(userId, LocalDateTime.now());

            BannerParam bannerParam = new BannerParam();
            bannerParam.init(); // 파라미터 초기화
            List<BannerDto> bannerList = bannerService.list(bannerParam); // 배너 목록 가져오기

            model.addAttribute("banners", bannerList);
        }

        return "index";
    }



    @RequestMapping("/error/denied")
    public String errorDenied() {

        return "error/denied";
    }



}