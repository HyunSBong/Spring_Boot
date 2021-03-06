package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {

    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public long join(Member member) {

        validateDuplicateMember(member);

        /*
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원합니다.");
        });
         */

        /*
         * 또는
         * 어차피 반환 값이 Optional 이므로
         * memberRepository.findByName(member.getName());
                   .ifPresent(m -> {
                        throw new IllegalStateException("이미 존재하는 회원합니다.");
                    });
         * */

        memberRepository.save(member);
        return member.getId();
    }

    // 같은 이름의 중복 회원 검증
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                // Null이면...
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     *전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
