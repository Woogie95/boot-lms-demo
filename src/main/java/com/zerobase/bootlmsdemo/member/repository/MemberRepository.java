package com.zerobase.bootlmsdemo.member.repository;

import com.zerobase.bootlmsdemo.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

}
