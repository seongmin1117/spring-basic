package com.devsm.springbasic.member;

import org.assertj.core.api.Assertions; // import 주의
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService  = new MemberServiceImpl();
    @Test
    void join() {

        //given
        Member member = new Member(1L,"memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(findMember).isEqualTo(member);
    }
}
