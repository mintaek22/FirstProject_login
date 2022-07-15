package com.FirstProject_login.FirstProject_login.Service;

import com.FirstProject_login.FirstProject_login.Repository.MemberRepository;
import com.FirstProject_login.FirstProject_login.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
    회원가입
     */
    public Long join(Member member){
        memberRepository.save(member);
        return member.getIndex();
    }

    /**
    전체 회원 정보 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

}
