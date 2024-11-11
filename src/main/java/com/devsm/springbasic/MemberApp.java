package com.devsm.springbasic;

import com.devsm.springbasic.member.Grade;
import com.devsm.springbasic.member.Member;
import com.devsm.springbasic.member.MemberService;
import com.devsm.springbasic.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + findMember.getName());
        System.out.println("find Member = " + member.getName());
    }
}
