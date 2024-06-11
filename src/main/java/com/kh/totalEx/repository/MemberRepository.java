package com.kh.totalEx.repository;

import com.kh.totalEx.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email); // 개별 회원 정보 조회
    Optional<Member> findByEmailAndPwd(String email, String pwd); // 로그인 체크

    boolean existsByEmail(String email);
}

// [ JUnit 테스트에서 ]

// 1. 전체 회원 조회 / ok~
// 2. 이메일로 개별 회원 조회 / ok~
// 3. 가입 여부 확인(이메일로 가입 여부 확인) / ok~
// 4. 로그인 체크 / ok~

