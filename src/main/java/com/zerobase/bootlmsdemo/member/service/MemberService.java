package com.zerobase.bootlmsdemo.member.service;

import com.zerobase.bootlmsdemo.member.model.MemberInput;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    boolean register(MemberInput memberInput);

    boolean emailAuth(String uuid);
}
