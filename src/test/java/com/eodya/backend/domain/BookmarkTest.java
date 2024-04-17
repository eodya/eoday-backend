package com.eodya.backend.domain;

import com.eodya.backend.bookmark.domain.Bookmark;
import com.eodya.backend.fixture.domain.BookmarkFixture;
import com.eodya.backend.fixture.domain.MemberFixture;
import com.eodya.backend.member.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookmarkTest {

    @Test
    @DisplayName("정상적으로 북마크를 생성할 수 있다.")
    void createBookmark_Success() {
        //given
        Bookmark bookmark = BookmarkFixture.bookmarkBuilder();

        //when & then
        assertEquals("테스트 이메일", bookmark.getMember().getEmail());
        assertEquals("테스트 닉네임", bookmark.getMember().getNickname());
        assertEquals("테스트 프로필 이미지 URL", bookmark.getMember().getProfileImageUrl());
        assertEquals("테스트 장소", bookmark.getPlace().getName());
        assertEquals("서울특별시 강남구 논현동", bookmark.getPlace().getAddressDetail());

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("정상적으로, 여러개의 북마크를 생성할 수 있다.")
    void createBookmarks_Success(int count) {
        //given
        Member member = MemberFixture.memberBuild();
        List<Bookmark> bookmarks = BookmarkFixture.bookmarksBuilder(count, member);

        //when & then
        assertEquals(count, bookmarks.size());

        IntStream.range(0, count).forEach(i -> {
            Bookmark bookmark = bookmarks.get(i);
            assertEquals("테스트 이메일", bookmark.getMember().getEmail());
            assertEquals("테스트 닉네임", bookmark.getMember().getNickname());
            assertEquals("테스트 프로필 이미지 URL", bookmark.getMember().getProfileImageUrl());
            assertEquals(String.format("테스트 장소 %d", i), bookmark.getPlace().getName());
            assertEquals(String.format("서울특별시 강남구 논현동 %d", i), bookmark.getPlace().getAddressDetail());
        });
    }
}
