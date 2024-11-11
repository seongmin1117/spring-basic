package com.devsm.springbasic.order;

public interface OrderService {
    //주문생성 후 최종 주문결과 반환
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
