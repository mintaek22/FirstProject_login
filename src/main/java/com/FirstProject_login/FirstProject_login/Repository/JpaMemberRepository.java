package com.FirstProject_login.FirstProject_login.Repository;

import com.FirstProject_login.FirstProject_login.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    @Autowired
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findByIndex(Long index) {
        Member member = em.find(Member.class, index);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findById_Password(String id,String password) {
        List<Member> result = em.createQuery("select m from Member m where m.id=:id AND m.password=:password", Member.class)
                .setParameter("id",id)
                .setParameter("password",password)
                .getResultList();
        return result.stream().findAny();
    }


    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member as m",Member.class)
                .getResultList();
    }
}
