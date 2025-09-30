package codeit.sb06.springdatajpa.member;

import codeit.sb06.springdatajpa.progress.ProgressDto;
import codeit.sb06.springdatajpa.progress.ProgressMapper;
import codeit.sb06.springdatajpa.progress.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;
    private final ProgressMapper progressMapper;

    @PostMapping
    public ResponseEntity<MemberDto.Response> postMember(@RequestBody MemberDto.Post requestBody) {
        Member createdMember = memberService.createMember(requestBody);
        MemberDto.Response response = memberMapper.memberToMemberResponseDto(createdMember);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{memberId}/progresses")
    public ResponseEntity<List<ProgressDto.Response>> getProgresses(@PathVariable Long memberId) {
        List<ProgressDto.Response> progresses = memberService.getProgresses(memberId).stream()
                .map(progressMapper::progressToProgressResponseDto)
                .toList();
        return ResponseEntity.ok(progresses);
    }
}
