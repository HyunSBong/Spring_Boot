package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.*;
/*
 동시성 문제가 고려되어 있지 X
 실무에서는 ConcurrentHashMap, AtomicLong 사용을 고려할 수 있다.
 */

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // store.getId()가 null 경우 Optional로 처리
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // 찾으면 반환, 없으면 Optional에 null이 포함되어 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    // repository 초기화
    public void clearStore() {
        store.clear();
    }
}
