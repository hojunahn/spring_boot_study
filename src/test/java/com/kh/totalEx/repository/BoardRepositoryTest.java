package com.kh.totalEx.repository;

import com.kh.totalEx.entity.Board;
import com.kh.totalEx.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Test
    @DisplayName("게시글 정보 저장")
    public void createBoardTest(){
        for (int i = 1; i<=10; i++){
            Board board = new Board();
            board.setTitle("제목"+i);
            board.setContent("정보"+i);
            board.setImgPath("url"+i);
            board.setRegDate(LocalDateTime.now());
            boardRepository.save(board);
        }
    }

    @Test
    @DisplayName("게시글 키워드 검색")
    public void searchKeyWord() {
        this.createBoardTest();
        List<Board> searchKeyWord = boardRepository.findByContentContaining("보1");
        for(Board e : searchKeyWord) System.out.println(e.toString());

    }

    @Test
    @DisplayName("게시글 전체 보기")
    public void boardAll() {
        this.createBoardTest();
        List<Board> boardAllSearch = boardRepository.findAll();
        for(Board e : boardAllSearch) System.out.println(e.getContent());
    }
}