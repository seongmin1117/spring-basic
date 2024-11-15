package com.devsm.springbasic;

import com.devsm.springbasic.discount.DiscountPolicy;
import com.devsm.springbasic.discount.FixDiscountPolicy;
import com.devsm.springbasic.member.MemberRepository;
import com.devsm.springbasic.member.MemberService;
import com.devsm.springbasic.member.MemberServiceImpl;
import com.devsm.springbasic.member.MemoryMemberRepository;
import com.devsm.springbasic.order.OrderService;
import com.devsm.springbasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // 생성자 주입
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
