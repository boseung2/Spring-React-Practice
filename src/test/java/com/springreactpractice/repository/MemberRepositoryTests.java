package com.springreactpractice.repository;

import com.springreactpractice.entity.Member;
import com.springreactpractice.entity.MemberRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Member sampleMember;



    /*

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Member member = Member.builder()
                    .email("user" + i + "@naver.com")
                    .name("사용자" + i)
                    .fromSocial(false)
                    .password(passwordEncoder.encode("1111"))
                    .build();

            member.addMemberRole(MemberRole.USER);
            if(i > 80) {
                member.addMemberRole(MemberRole.MANAGER);
            }

            if(i > 90) {
                member.addMemberRole(MemberRole.ADMIN);
            }

            memberRepository.save(member);
        });

    };

    */

    /*
    repository test 순서?

    C create 하나 넣어 보기
    R read  하나 갖고 와보기
    U update ?
    D delete 넣은거 삭제해보기
     */

    @BeforeEach
    public void setUp() {

        sampleMember = Member.builder()
                .email("sampleMember@naver.com")
                .name("sample")
                .password(passwordEncoder.encode("1111"))
                .fromSocial(false)
                .build();

        sampleMember.addMemberRole(MemberRole.USER);

    }

    @Test
    public void testInsert() {

        // sampleMember 저장
        memberRepository.save(sampleMember);

        // sampleMember 읽은 뒤, 읽은 값과 같은지 확인
        Optional<Member> member = memberRepository.findByEmail(sampleMember.getEmail(), sampleMember.isFromSocial());

        if(member.isPresent()) {
            assert(member.get().getEmail().equals(sampleMember.getEmail()));
        }

        // sampleMember 삭제한 뒤, 읽어서 존재 안하는지 확인
        memberRepository.deleteById(sampleMember.getEmail());
        member = memberRepository.findByEmail(sampleMember.getEmail(), sampleMember.isFromSocial());

        assert(!member.isPresent());

    }

}
