package codeit.sb06.springdatajpa.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public class MemberDto {

    @Getter
    public static class Post {
        private String email;
        private String nickname;
        private String password;
        private String profileImageUrl;
    }

    @Getter
    public static class ProfilePatch {
        private String introduction;
        private String websiteUrl;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long memberId;
        private String email;
        private String nickname;
        private Member.SubscribeStatus subscribeStatus;
        private LocalDateTime createdAt;
        private ProfileResponse profile;

        public Response(Member member) {
            this.memberId = member.getMemberId();
            this.email = member.getEmail();
            this.nickname = member.getNickname();
            this.subscribeStatus = member.getSubscribeStatus();
            this.createdAt = member.getCreatedAt();
            if (member.getMemberProfile() != null) {
                this.profile = new ProfileResponse(member.getMemberProfile());
            }
        }
    }

    @Getter
    @AllArgsConstructor
    public static class ProfileResponse {
        private String introduction;
        private String websiteUrl;
        private String profileImageUrl;

        public ProfileResponse(MemberProfile profile) {
            this.introduction = profile.getIntroduction();
            this.websiteUrl = profile.getWebsiteUrl();
            this.profileImageUrl = profile.getProfileImageUrl();
        }
    }
}
