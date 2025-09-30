package codeit.sb06.springdatajpa.course;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @PostMapping
    public ResponseEntity<CourseDto.Response> postCourse(@RequestBody CourseDto.Post requestBody) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseMapper.courseToCourseResponseDto(courseService.createCourse(requestBody)));
    }
}
