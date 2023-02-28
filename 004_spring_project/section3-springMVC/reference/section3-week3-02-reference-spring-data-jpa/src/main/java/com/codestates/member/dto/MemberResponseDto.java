package com.codestates.member.dto;

import com.codestates.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

// TODO 변경: Builder 패턴 적용
@Builder
@Getter
public class MemberResponseDto {
    private long memberId;
    private String email;
    private String name;
    private String phone;
    private Member.MemberStatus memberStatus;   // TODO 추가된 부분
//    private String memberStatus;   // Mapper에 매핑 시

    // TODO 수정된 부분
    // ResponseEntity 에서 해당 getter를 이용해 String 타입의 status값을 가져온다.
    public String getMemberStatus() {
        return memberStatus.getStatus();
    }
}
