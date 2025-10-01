package codeit.sb06.springdatajpa.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public class CommentDto {

    @Getter
    public static class Post {
        private long memberId;
        private long courseId;
        private String content;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private long commentId;
        private long memberId;
        private String nickname;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Response(Comment comment) {
            this.commentId = comment.getCommentId();
            this.memberId = comment.getMember().getMemberId();
            this.nickname = comment.getMember().getNickname();
            this.content = comment.getContent();
            this.createdAt = comment.getCreatedAt();
            this.updatedAt = comment.getUpdatedAt();
        }
    }
}
