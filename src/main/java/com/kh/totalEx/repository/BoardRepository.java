package com.kh.totalEx.repository;

import com.kh.totalEx.entity.Board;
import com.kh.totalEx.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByContentContaining(String Content);

    List<Board> findByContent(String content);
    // 본문 내용에 포함된 키워드로 검색
    // 게시글 전체 보기
}
