package org.zerock.springreactpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.springreactpractice.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
}
