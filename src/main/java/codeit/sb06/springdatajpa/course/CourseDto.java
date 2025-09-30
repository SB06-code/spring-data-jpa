package codeit.sb06.springdatajpa.course;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public class CourseDto {

    @Getter
    public static class Post {
        private String title;
        private String category;
        private String description;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long courseId;
        private String title;
        private String category;
        private String description;
        private LocalDateTime createdAt;
    }
}
