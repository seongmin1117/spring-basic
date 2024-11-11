package com.devsm.springbasic.order;

import com.devsm.springbasic.discount.DiscountPolicy;
import com.devsm.springbasic.discount.FixDiscountPolicy;
import com.devsm.springbasic.member.Member;
import com.devsm.springbasic.member.MemberRepository;
import com.devsm.springbasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 어떤 것을 파람으로 받고 어떻게 반환해줄지는 프로젝트에 따라 다르다.
        Member member = memberRepository.findById(memberId);

        // 주문서비스입장에서 할인에 대한 자세한 사항을 모르므로 책임이 없음. 단일책임원칙 준수
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
