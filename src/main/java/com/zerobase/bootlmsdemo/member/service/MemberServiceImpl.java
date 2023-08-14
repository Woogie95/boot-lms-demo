package com.zerobase.bootlmsdemo.member.service;

import com.zerobase.bootlmsdemo.member.entity.Member;
import com.zerobase.bootlmsdemo.member.model.MemberInput;
import com.zerobase.bootlmsdemo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public boolean register(MemberInput memberInput) {

        Optional<Member> optionalMember = memberRepository.findById(memberInput.getUserId());
        if (optionalMember.isPresent()) {
            return false;
        }

        Member member = new Member();
        member.setUserId(memberInput.getUserId());
        member.setUserName(memberInput.getUserName());
        member.setPhone(memberInput.getPhone());
        member.setPassword(memberInput.getPassword());
        member.setRegistered(LocalDateTime.now());
        memberRepository.save(member);
        return false;
    }
}
