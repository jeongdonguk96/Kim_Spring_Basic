package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findBeanByName() {
        MemberService memberService = context.getBean("memberService", MemberService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("이름없이 타입으로 조회")
    void findBeanByBean() {
        MemberService memberService = context.getBean(MemberService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberService memberService = context.getBean("memberService", MemberServiceImpl.class);

        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName3() {
//        MemberService memberService = context.getBean("xxxxx", MemberService.class);

        assertThrows(NoSuchBeanDefinitionException.class, () -> context.getBean("xxxxx", MemberService.class));
    }
}



















