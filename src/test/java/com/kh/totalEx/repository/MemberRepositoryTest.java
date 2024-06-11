package com.kh.totalEx.repository;

import com.kh.totalEx.entity.Item;
import com.kh.totalEx.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("회원 정보 저장")
    public void createUserTest(){
        for (int i = 1; i<=10; i++){
            Member member = new Member();
            member.setName("테스트"+i);
            member.setEmail("테스트이메일"+i);
            member.setPwd("테스트비밀번호"+i);
            member.setImage("테스트이미지"+i);
            member.setRegDate(LocalDateTime.now());
            memberRepository.save(member);
        }
    }

    @Test
    @DisplayName("회원 정보 조회")
    public void findByAllUserTest(){
        this.createUserTest();
        List<Member> UserInfo = memberRepository.findAll();

        for (Member e : UserInfo) {
            System.out.println("Name: " + e.getName());
            System.out.println("Email: " + e.getEmail());
            System.out.println("Password: " + e.getPwd());
            System.out.println("Image: " + e.getImage());
            System.out.println("Registration Date: " + e.getRegDate());
        }
    }

    @Test
    @DisplayName("이메일로 개별 회원 조회")
    public void findByEmailUserTest() {
        this.createUserTest();
        String testEmail = "테스트이메일5";
        Optional<Member> UserEmail = memberRepository.findByEmail(testEmail);
        System.out.println(UserEmail);
   }

   @Test
    @DisplayName("유저 가입 여부 확인(이메일)")
    public void checkUserSignTest(){
        this.createUserTest();
        String trueUser = "테스트이메일3";
        String falseUser = "테스트이메일13";

        Optional<Member> UsersSignCheck = memberRepository.findByEmail(trueUser);
        Optional<Member> UsersSignCheck1 = memberRepository.findByEmail(falseUser);

       System.out.println(UsersSignCheck.isPresent());
       System.out.println(UsersSignCheck1.isPresent());
   }

   @Test
    @DisplayName("로그인 체크")
    public void LoginCheckTest(){
        this.createUserTest();

        String UserEmail = "테스트이메일3";
        String UserPwd = "테스트비밀번호3";

        Optional<Member> UsersLoginCheck = memberRepository.findByEmailAndPwd(UserEmail,UserPwd);
       System.out.println(UsersLoginCheck.isPresent());
   }



}