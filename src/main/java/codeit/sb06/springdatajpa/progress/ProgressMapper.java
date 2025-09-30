package codeit.sb06.springdatajpa.progress;

import org.springframework.stereotype.Component;

@Component
public class ProgressMapper {

    public ProgressDto.Response progressToProgressResponseDto(Progress progress) {
        return new ProgressDto.Response(
                progress.getProgressId(),
                progress.getMember().getMemberId(),
                progress.getMember().getNickname(),
                progress.getCourse().getCourseId(),
                progress.getCourse().getTitle(),
                progress.getProgressRate(),
                progress.isCompleted(),
                progress.getUpdatedAt()
        );
    }
}
