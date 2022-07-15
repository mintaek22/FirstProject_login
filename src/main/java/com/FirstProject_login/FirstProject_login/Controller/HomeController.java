package com.FirstProject_login.FirstProject_login.Controller;

import com.FirstProject_login.FirstProject_login.Service.MemberService;
import com.FirstProject_login.FirstProject_login.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Controller
public class HomeController {

    private final MemberService memberService;

    @Autowired
    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("home")
    public String home(){
        return "home";
    }

    @GetMapping("home/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("home/signup")
    public String create(MemberForm form){
        Member member =new Member();
        member.setId(form.getId());
        member.setPassword(form.getPassword());
        memberService.join(member);
        return "redirect:/home";
    }

    @PostMapping("home/login")
    public String login_check(MemberForm form){
        //현재 db에 있는 회원 정보
        List<Member> memberList=memberService.findMembers();

        for (Member member : memberList) {
            if (Objects.equals(member.getId(), form.getId())) {
                if (Objects.equals(member.getPassword(), form.getPassword())) {
                    return "redirect:/home/login";
                }
            }
        }
        return  "redirect:/home";
    }

    @GetMapping("home/login")
    public String login_home(){

        return "login_home";
    }
}
