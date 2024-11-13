package com.devsm.springbasic.discount;

import com.devsm.springbasic.member.Grade;
import com.devsm.springbasic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return price * discountPercent/100;
        }
        return 0;
    }
}
