package com.zerobase.bootlmsdemo.member.service;

import com.zerobase.bootlmsdemo.member.model.MemberInput;

public interface MemberService {

    boolean register(MemberInput memberInput);

    boolean emailAuth(String uuid);
}
