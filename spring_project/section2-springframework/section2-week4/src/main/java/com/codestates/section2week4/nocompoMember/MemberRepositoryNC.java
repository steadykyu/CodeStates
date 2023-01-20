package com.codestates.section2week4.nocompoMember;

import java.util.HashMap;
import java.util.Map;

public class MemberRepositoryNC {
    private static Map<Long, MemberNC> members = new HashMap<>();

    public void postMember(MemberNC memberNC) {
        members.put(memberNC.getMemberId(), memberNC);
    }

    public MemberNC getMember(Long memberId) {
        return members.get(memberId);
    }

    public void deleteMember(Long memberId) {
        members.remove(memberId);
    }
}
