package com.zerobase.bootlmsdemo.member.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Member {

    @Id
    @Column(unique = true)
    private String userId;

    private String userName;
    private String phone;
    private String password;
    private LocalDateTime registered;

    private boolean emailAuthYn;
    private String emailAuthKey;

}
