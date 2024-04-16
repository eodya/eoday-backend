package com.eodya.backend.member.domain;

import com.eodya.backend.auth.domain.OauthProvider;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 100)
    private String email;

    @NotNull
    @Column(length = 30)
    private String nickname;

    @NotNull
    @Column(length = 100)
    private String profileImageUrl;

    @NotNull
    private Integer oauthId;

    @NotNull
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
