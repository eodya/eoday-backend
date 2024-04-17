package com.eodya.backend.domain;

import com.eodya.backend.fixture.domain.MemberFixture;
import com.eodya.backend.member.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;

import static com.eodya.backend.auth.domain.OauthProvider.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MemberTest {

    @Test
    @DisplayName("정상적으로 회원을 생성할 수 있다.")
    void createMember_Success() {
        //given
        Member member = MemberFixture.memberBuild();

        //when & then
        assertEquals("테스트 이메일", member.getEmail());
        assertEquals("테스트 닉네임", member.getNickname());
        assertEquals("테스트 프로필 이미지 URL", member.getProfileImageUrl());
        assertEquals(1, member.getOauthId());
        assertEquals(KAKAO, member.getOauthProvider());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("정상적으로 여러 명의 회원을 생성할 수 있다.")
    void createMembers_Success(int count) {
        //given
        List<Member> members = MemberFixture.membersBuild(count, KAKAO);

        //when & then
        assertEquals(count, members.size());

        IntStream.range(0, count).forEach(i -> {
            Member member = members.get(i);
            assertEquals(String.format("테스트 이메일 %d", i), member.getEmail());
            assertEquals(String.format("테스트 닉네임 %d", i), member.getNickname());
            assertEquals(String.format("테스트 프로필 이미지 URL %d", i), member.getProfileImageUrl());
            assertEquals(i + 1, member.getOauthId());
            assertEquals(KAKAO, member.getOauthProvider());
        });
    }
}
