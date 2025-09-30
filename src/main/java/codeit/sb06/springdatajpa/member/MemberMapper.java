package codeit.sb06.springdatajpa.member;

import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member memberPostDtoToMember(MemberDto.Post requestBody) {
        // The profileImageUrl is handled in the service layer now
        return new Member(
                requestBody.getEmail(),
                requestBody.getNickname(),
                requestBody.getPassword()
        );
    }

    public MemberDto.Response memberToMemberResponseDto(Member member) {
        return new MemberDto.Response(member);
    }
}
