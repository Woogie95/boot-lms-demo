package com.zerobase.bootlmsdemo.member.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberInput {

    private String userId;
    private String userName;
    private String phone;
    private String password;
    private LocalDateTime registered;


}
