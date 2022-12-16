package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//커맨드 쉬프트 T : 테스트 만들기
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    //싱글톤으로 생성
    private static final MemberRepository instance = new MemberRepository();

    //이것으로만 조회되게하기
    public static MemberRepository getInstance(){
        return instance;
    }
    //싱글톤은 private로 생성자 막아서 아무나 생성하지 못하게하기
    private MemberRepository(){

    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    //스토어 다 날리기
    public void clearStore(){
        store.clear();
    }

}
