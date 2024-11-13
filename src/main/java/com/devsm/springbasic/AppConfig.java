package com.devsm.springbasic;

import com.devsm.springbasic.discount.DiscountPolicy;
import com.devsm.springbasic.discount.FixDiscountPolicy;
import com.devsm.springbasic.member.MemberRepository;
import com.devsm.springbasic.member.MemberService;
import com.devsm.springbasic.member.MemberServiceImpl;
import com.devsm.springbasic.member.MemoryMemberRepository;
import com.devsm.springbasic.order.OrderService;
import com.devsm.springbasic.order.OrderServiceImpl;

public class AppConfig {

    // 생성자 주입
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
