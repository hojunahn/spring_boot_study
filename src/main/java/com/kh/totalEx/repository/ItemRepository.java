package com.kh.totalEx.repository;

import com.kh.totalEx.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemNm(String itemNm); // select item_nm from item where item_nm = 'ddd'
    List<Item> findByPrice(int price);
    // or 조건 처리 하기
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
    // LessThan : 보다 작다라는 의미
//    List<Item> findByItemPrice(int price);
    // 정렬
    List<Item> findByPriceLessThanOrderByPriceDesc(int price);

}
