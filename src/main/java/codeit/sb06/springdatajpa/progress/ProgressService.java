package codeit.sb06.springdatajpa.progress;

import codeit.sb06.springdatajpa.course.Course;
import codeit.sb06.springdatajpa.course.CourseRepository;
import codeit.sb06.springdatajpa.member.Member;
import codeit.sb06.springdatajpa.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProgressService {

    private final ProgressRepository progressRepository;
    private final MemberRepository memberRepository;
    private final CourseRepository courseRepository;

    public Progress createProgress(ProgressDto.Post requestBody) {
        Member member = memberRepository.findById(requestBody.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        Course course = courseRepository.findById(requestBody.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        Progress progress = new Progress(member, course);
        return progressRepository.save(progress);
    }
}
