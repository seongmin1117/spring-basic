package com.devsm.springbasic;

import com.devsm.springbasic.member.Grade;
import com.devsm.springbasic.member.Member;
import com.devsm.springbasic.member.MemberService;
import com.devsm.springbasic.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // name: 메서드이름 , 타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + findMember.getName());
        System.out.println("find Member = " + member.getName());
    }
}
