package codeit.sb06.springdatajpa.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public Course createCourse(CourseDto.Post requestBody) {
        return courseRepository.save(
                courseMapper.coursePostDtoToCourse(requestBody)
        );
    }
}
