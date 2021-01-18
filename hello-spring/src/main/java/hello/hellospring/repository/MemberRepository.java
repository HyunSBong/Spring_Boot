package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

// 희원 레포지토리 인터페이스
public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findbyId(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}