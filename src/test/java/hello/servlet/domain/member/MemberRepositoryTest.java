package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

//static import
import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {

    //싱글톤이라 new 생성 no. 스프링으로 한다면 스프링은 싱글톤을 보장해주기에 하기진행 안해도됨.
    MemberRepository memberRepository = MemberRepository.getInstance();

    //테스트 끝난후 실행
    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("hello", 20);

        //when
        Member saveMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        ///static import 단축기 : option + enter
        //Assertions.assertThat(result.size()).isEqualTo(2);
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}
