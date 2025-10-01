package codeit.sb06.springdatajpa.member;

import codeit.sb06.springdatajpa.progress.Progress;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter(AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 50)
    private String nickname;

    @Column(nullable = false, length = 200)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SubscribeStatus subscribeStatus = SubscribeStatus.INACTIVE;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    private MemberProfile memberProfile;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Progress> progresses = new ArrayList<>();

    public enum SubscribeStatus {
        ACTIVE, INACTIVE
    }

    public Member(String email, String nickname, String passwordHash) {
        this.email = email;
        this.nickname = nickname;
        this.passwordHash = passwordHash;
    }

    public void setMemberProfile(MemberProfile memberProfile) {
        this.memberProfile = memberProfile;
        if (memberProfile != null && memberProfile.getMember() != this)
            memberProfile.setMember(this);
    }
}
