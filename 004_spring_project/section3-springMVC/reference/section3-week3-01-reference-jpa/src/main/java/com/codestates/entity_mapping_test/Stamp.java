package com.codestates.entity_mapping_test;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Stamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stampId;

    @Column(nullable = false)
    private int stampCount;

    @Setter(AccessLevel.NONE) // 외부에서 Setter를 못쓰게 하고 addMember()를 쓰도록 하기 위해 작성
    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public void addMember(Member member) {
        this.member = member;
        if (member.getStamp() != this) {
            member.addStamp(this);
        }
    }
}
