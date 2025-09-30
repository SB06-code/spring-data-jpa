package codeit.sb06.springdatajpa.progress;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/progresses")
@RequiredArgsConstructor
public class ProgressController {

    private final ProgressService progressService;
    private final ProgressMapper progressMapper;

    @PostMapping
    public ResponseEntity<ProgressDto.Response> postProgress(@RequestBody ProgressDto.Post requestBody) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        progressMapper.progressToProgressResponseDto(
                                progressService.createProgress(requestBody)
                        )
                );
    }
}
