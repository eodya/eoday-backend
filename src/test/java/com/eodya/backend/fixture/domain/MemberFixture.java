package com.eodya.backend.fixture.domain;

import com.eodya.backend.auth.domain.OauthProvider;
import com.eodya.backend.member.domain.Member;

import java.util.List;
import java.util.stream.IntStream;

import static com.eodya.backend.auth.domain.OauthProvider.*;

public class MemberFixture {

    public static Member memberBuild() {
        return Member.builder()
                .email("테스트 이메일")
                .nickname("테스트 닉네임")
                .profileImageUrl("테스트 프로필 이미지 URL")
                .oauthId(1)
                .oauthProvider(KAKAO)
                .build();
    }

    public static List<Member> membersBuild(int count, OauthProvider oauthProvider) {
        return IntStream.range(0, count)
                .mapToObj(i -> Member.builder()
                        .email(String.format("테스트 이메일 %d", i))
                        .nickname(String.format("테스트 닉네임 %d", i))
                        .profileImageUrl(String.format("테스트 프로필 이미지 URL %d", i))
                        .oauthId(i + 1)
                        .oauthProvider(oauthProvider)
                        .build())
                .toList();
    }
}
