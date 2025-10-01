package codeit.sb06.springdatajpa.comment;

import codeit.sb06.springdatajpa.course.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(
            value = "SELECT c FROM Comment c "
                    + "JOIN FETCH c.member m "
                    + "LEFT JOIN FETCH m.memberProfile "
                    + "WHERE c.course = :course"
//            , countQuery = "SELECT count(c) FROM Comment c WHERE c.course = :course"
    )
    Slice<Comment> findByCourse(@Param("course") Course course, Pageable page);
}
