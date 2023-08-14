package com.zerobase.bootlmsdemo.member.service.imlp;

import com.zerobase.bootlmsdemo.member.entity.Member;
import com.zerobase.bootlmsdemo.member.model.MemberInput;
import com.zerobase.bootlmsdemo.member.repository.MemberRepository;
import com.zerobase.bootlmsdemo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

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
        member.setEmailAuthYn(false);
        member.setEmailAuthKey(UUID.randomUUID().toString());
        memberRepository.save(member);

        String email = memberInput.getUserId();
        String subject = "fastlms 사이트 가입을 축하드립니다.";
        String text = "<p> fastlms 사이트 가입을 축하드립니다."
        return true;
    }
}
