package org.zerock.springreactpractice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.springreactpractice.entity.Member2;

import java.util.stream.IntStream;

@SpringBootTest
public class Member2RepositoryTests {

    @Autowired
    Member2Repository memberRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Test
    public void insertMembers() {

        IntStream.rangeClosed(1, 100).forEach(i -> {
            Member2 member = Member2.builder()
                    .email("r" + i + "@zerock.org")
                    .pw("1111")
                    .nickname("reviewer" + i).build();

            memberRepository.save(member);
        });

    }

    @Commit
    @Transactional
    @Test
    public void testDeleteMember() {

        Long mid = 2L;

        Member2 member = Member2.builder().mid(mid).build();

        // 순서 주의
        reviewRepository.deleteByMember(member);
        memberRepository.deleteById(mid);

    }

}
