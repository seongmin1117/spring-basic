package com.devsm.springbasic.order;

import com.devsm.springbasic.AppConfig;
import com.devsm.springbasic.member.Grade;
import com.devsm.springbasic.member.Member;
import com.devsm.springbasic.member.MemberService;
import com.devsm.springbasic.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order= " + order.toString());
    }
}
