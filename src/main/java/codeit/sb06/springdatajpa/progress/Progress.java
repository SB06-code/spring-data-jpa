package codeit.sb06.springdatajpa.progress;

import codeit.sb06.springdatajpa.course.Course;
import codeit.sb06.springdatajpa.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "progresses",
        uniqueConstraints = @UniqueConstraint(columnNames = {"member_id", "course_id"})
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter(AccessLevel.PROTECTED)
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long progressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(nullable = false)
    private int lastWatchTime = 0;

    @Column(nullable = false, precision = 5)
    private double progressRate = 0.0;

    @Column(nullable = false)
    private boolean isCompleted = false;

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Progress(Member member, Course course) {
        this.member = member;
        this.course = course;
    }
}
