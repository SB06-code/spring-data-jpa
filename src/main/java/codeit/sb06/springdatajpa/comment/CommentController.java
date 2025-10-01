package codeit.sb06.springdatajpa.comment;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments")
    public ResponseEntity<CommentDto.Response> postComment(@RequestBody CommentDto.Post requestBody) {
        CommentDto.Response comment = commentService.createComment(requestBody);

        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }

    @GetMapping("/courses/{course-id}/comments")
    public ResponseEntity<Slice<CommentDto.Response>> getComments(
            @PathVariable("course-id") long courseId,
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "createdAt"));
        Slice<CommentDto.Response> responsePage = commentService.findCommentsByCourse(courseId, pageable);
        return ResponseEntity.ok(responsePage);
    }
}
