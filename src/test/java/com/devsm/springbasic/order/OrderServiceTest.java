package com.devsm.springbasic.order;

import com.devsm.springbasic.AppConfig;
import com.devsm.springbasic.member.Grade;
import com.devsm.springbasic.member.Member;
import com.devsm.springbasic.member.MemberService;
import com.devsm.springbasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    /*
     orderService는  import 구문이 없어도 동작하는 이유
     src/main/java와 src/test/java는 소스 디렉토리가 다르더라도 패키지 구조가 동일하다면 같은 패키지로 간주된다.
     */
    OrderService orderService;

    @BeforeEach
    public void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    // 단위테스트 : 스프링 도움 없이 순수 자바코드로 테스트 하는 것
    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
