package codeit.sb06.springdatajpa.progress;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public class ProgressDto {

    @Getter
    public static class Post {
        private long memberId;
        private long courseId;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private long progressId;
        private long memberId;
        private String memberNickname;
        private long courseId;
        private String courseTitle;
        private double progressRate;
        private boolean isCompleted;
        private LocalDateTime updatedAt;
    }
}
