package com.eodya.backend.member.domain;

import com.eodya.backend.auth.domain.OauthProvider;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 30, nullable = false, unique = true)
    private String nickname;

    @Column(length = 100, nullable = false)
    private String profileImageUrl;

    @Column(nullable = false, unique = true)
    private Integer oauthId;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private OauthProvider oauthProvider;

    @Embedded
    private MemberPlace memberPlace = new MemberPlace();

    @Embedded
    private MemberReview memberReview = new MemberReview();

    @Embedded
    private MemberBookmark memberBookmark = new MemberBookmark();

    @Embedded
    private MemberRecommendation memberRecommendation = new MemberRecommendation();

    @Builder
    private Member(
            String email,
            String nickname,
            String profileImageUrl,
            Integer oauthId,
            OauthProvider oauthProvider
    ) {
        this.email = email;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
        this.oauthId = oauthId;
        this.oauthProvider = oauthProvider;
    }
}
