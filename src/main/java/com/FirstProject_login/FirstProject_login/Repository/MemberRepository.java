package com.FirstProject_login.FirstProject_login.Repository;

import com.FirstProject_login.FirstProject_login.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByIndex(Long index);
    Optional<Member> findById_Password(String id,String password);
    List<Member> findAll();
}
