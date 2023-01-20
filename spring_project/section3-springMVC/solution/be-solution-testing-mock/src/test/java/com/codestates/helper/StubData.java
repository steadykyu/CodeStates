package com.codestates.helper;

import com.codestates.member.dto.MemberDto;
import com.codestates.member.entity.Member;
import com.codestates.order.entity.Order;
import com.codestates.stamp.Stamp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StubData {
    // 요청 Http 메서드와, RequestDto를 담고 있는 Map
        // 다른 클래스에서 어디든지 사용할 수 있게 static 으로 선언
        // 외부에서 변경하지 못하도록 private로 생성
    private static Map<HttpMethod, Object> stubRequestBody;
    static {
        stubRequestBody = new HashMap<>();
        stubRequestBody.put(HttpMethod.POST, new MemberDto.Post("hgd@gmail.com","홍길동",
                "010-1111-1111"));
        stubRequestBody.put(HttpMethod.PATCH,
                new MemberDto.Patch(0, "홍길동", "010-2222-2222", Member.MemberStatus.MEMBER_ACTIVE));
    }
    // 임시 Member Stub
    public static class MockMember {
        // Request Body에 담긴 객체 가져오기
        public static Object getRequestBody(HttpMethod method) {
            return stubRequestBody.get(method);
        }
        
        // ResponseBody 에 사용될 ResponseDto 가져오기
        public static MemberDto.Response getSingleResponseBody() {
            return new MemberDto.Response(1L,
                    "hgd@gmail.com",
                    "홍길동",
                    "010-1111-1111",
                    Member.MemberStatus.MEMBER_ACTIVE,
                    new Stamp());
        }
        
        // ResponseBody 에 사용될 ResponseDto 가져오기
            // ResponseDto에서 name과 phone에 null로 요청하는 경우 nullException이 발생하지 않도록 Optional로 처리
        public static MemberDto.Response getSingleResponseBody(String name, String phone, Member.MemberStatus memberStatus) {
            String optionalName = Optional.ofNullable(name).orElse("홍길동");
            String optionalPhone = Optional.ofNullable(phone).orElse("010-1111-1111");
            Member.MemberStatus
                    optionalMemberStatus = Optional.ofNullable(memberStatus).orElse(Member.MemberStatus.MEMBER_ACTIVE);
            return new MemberDto.Response(1L,
                    "hgd@gmail.com",
                    optionalName,
                    optionalPhone,
                    optionalMemberStatus,
                    new Stamp());
        }
        // Member 엔티티 가져오기
        public static Member getSingleResultMember(long memberId) {
            Member member = new Member("hgd@gmail.com", "홍길동", "010-1111-1111");
            member.setMemberId(memberId);
            member.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
            member.setStamp(new Stamp());
            return member;
        }
        // Member 엔티티 가져오기
            // name과 phone에 null로 요청하는 경우 nullException이 발생하지 않도록 Optional로 처리
            // 이런식으로 Map 형식으로 데이터를 읽어와 커스텀해서 사용해줄 수 도 있다.
        public static Member getSingleResultMember(long memberId, Map<String, String> updatedInfo) {
            String name = Optional.ofNullable(updatedInfo.get("name")).orElse("홍길동");
            String phone = Optional.ofNullable(updatedInfo.get("phone")).orElse("010-1111-1111");
            Member member = new Member("hgd@gmail.com", name, phone);
            member.setMemberId(memberId);
            member.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
            member.setStamp(new Stamp());
            return member;
        }
        // 여러 Member 엔티티 가져오기
        public static Page<Member> getMultiResultMember() {
            Member member1 = new Member("hgd1@gmail.com", "홍길동1", "010-1111-1111");
            member1.setMemberId(1L);  // 추가
            member1.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
            member1.setStamp(new Stamp());

            Member member2 = new Member("hgd2@gmail.com", "홍길동2", "010-2222-2222");
            member2.setMemberId(2L);  // 추가
            member2.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
            member2.setStamp(new Stamp());

            return new PageImpl<>(List.of(member1, member2),
                    PageRequest.of(0, 10, Sort.by("memberId").descending()), // 정렬 지원 안됨. DB에서 정렬하지 않으므로..
                    2);
        }
        // 여러개의 ResponseDto 가져오기
        public static List<MemberDto.Response> getMultiResponseBody() {
            return List.of(
                    new MemberDto.Response(1L,
                            "hgd1@gmail.com",
                            "홍길동1",
                            "010-1111-1111",
                            Member.MemberStatus.MEMBER_ACTIVE,
                            new Stamp()),
                    new MemberDto.Response(2L,
                            "hgd2@gmail.com",
                            "홍길동2",
                            "010-2222-2222",
                            Member.MemberStatus.MEMBER_ACTIVE,
                            new Stamp())
            );
        }
    }

    public static class MockOrder {
        public static Order getSingleResponseBody(long orderId) {
            Order order = new Order();
            order.setOrderId(orderId);
            order.setOrderStatus(Order.OrderStatus.ORDER_CONFIRM);

            return order;
        }
    }
}
