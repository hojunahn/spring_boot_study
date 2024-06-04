package com.kh.totalEx.entity;

import com.kh.totalEx.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity // JPA Entity 클래스임을 지정, Entity 클래스는 반드시 기본키를 가져야 함
@ToString
public class Item {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;           // 상품 코드

    @Column(nullable = false, length = 50)
    private String itemNm;     // 상품 명

    @Column(nullable = false)
    private int price;         // 가격

    @Column(nullable = false)
    private int stockNumber;   // 재고 수량

    @Lob // 일반적인 데이터베이스에서 저장하는 길이인 255개 이상의 문자를 저장하고 싶을 때 지정
    @Column(nullable = false)
    private String itemDetail; // 상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;
    private LocalDateTime regTime;
    private LocalDateTime updateTime;
}
