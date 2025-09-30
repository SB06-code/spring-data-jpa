package codeit.sb06.springdatajpa.course;

import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course coursePostDtoToCourse(CourseDto.Post requestBody) {
        return new Course(
                requestBody.getTitle(),
                requestBody.getCategory(),
                requestBody.getDescription()
        );
    }

    public CourseDto.Response courseToCourseResponseDto(Course course) {
        return new CourseDto.Response(
                course.getCourseId(),
                course.getTitle(),
                course.getCategory(),
                course.getDescription(),
                course.getCreatedAt()
        );
    }
}
