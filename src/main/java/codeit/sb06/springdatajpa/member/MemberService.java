package codeit.sb06.springdatajpa.member;

import codeit.sb06.springdatajpa.progress.Progress;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public Member createMember(MemberDto.Post requestBody) {
        Member member = memberMapper.memberPostDtoToMember(requestBody);

        MemberProfile memberProfile = new MemberProfile();
        memberProfile.setProfileImageUrl(requestBody.getProfileImageUrl());
        member.setMemberProfile(memberProfile);

        return memberRepository.save(member);
    }

    public List<Progress> getProgresses(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        List<Progress> progresses = member.getProgresses();
        return progresses;
    }
}
