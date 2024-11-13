package com.devsm.springbasic.order;

import com.devsm.springbasic.discount.DiscountPolicy;
import com.devsm.springbasic.discount.FixDiscountPolicy;
import com.devsm.springbasic.discount.RateDiscountPolicy;
import com.devsm.springbasic.member.Member;
import com.devsm.springbasic.member.MemberRepository;
import com.devsm.springbasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    //인터페이스에만 의존한다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 어떤 것을 파람으로 받고 어떻게 반환해줄지는 프로젝트에 따라 다르다.
        Member member = memberRepository.findById(memberId);

        // 주문서비스입장에서 할인에 대한 자세한 사항을 모르므로 책임이 없음. 단일책임원칙 준수
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
