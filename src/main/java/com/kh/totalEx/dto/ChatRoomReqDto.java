package com.kh.totalEx.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
// 채팅방 개설 요청
public class ChatRoomReqDto {
    private String email;
    private String name;
}
