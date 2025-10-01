package codeit.sb06.springdatajpa.comment;

import codeit.sb06.springdatajpa.course.Course;
import codeit.sb06.springdatajpa.course.CourseRepository;
import codeit.sb06.springdatajpa.member.Member;
import codeit.sb06.springdatajpa.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public CommentDto.Response createComment(CommentDto.Post commentPostDto) {
        Member member = memberRepository.findById(commentPostDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        Course course = courseRepository.findById(commentPostDto.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        Comment comment = new Comment(member, course, commentPostDto.getContent());
        commentRepository.save(comment);

        return new CommentDto.Response(comment);
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public Slice<CommentDto.Response> findCommentsByCourse(long courseId, Pageable pageable) {
        Course course = courseRepository.findById(courseId)
                        .orElseThrow(() -> new IllegalArgumentException("Course not found"));
        Slice<Comment> commentPage = commentRepository.findByCourse(course, pageable);

        return commentPage.map(CommentDto.Response::new);
    }
}
