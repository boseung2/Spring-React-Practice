package org.zerock.springreactpractice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.springreactpractice.entity.ClubMember;

import java.util.Optional;

@SpringBootTest
public class ClubMemberTests {

    @Autowired
    ClubMemberRepository clubMemberRepository;

    @Test
    public void testRead() {

        Optional<ClubMember> result = clubMemberRepository.findByEmail("user95@zerock.org", false);

        ClubMember clubMember = result.get();

        System.out.println(clubMember);

    }
}
