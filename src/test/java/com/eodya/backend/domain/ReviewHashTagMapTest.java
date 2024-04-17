package com.eodya.backend.domain;

import com.eodya.backend.fixture.domain.ReviewHashTagMapFixture;
import com.eodya.backend.place.domain.PlaceStatus;
import com.eodya.backend.review.domain.ReviewHashTagMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReviewHashTagMapTest {

    @Test
    @DisplayName("정상적으로 리뷰와 해시태그를 매핑을 생성할 수 있다.")
    void createReviewHashTagMap_Success() {
        //given
        ReviewHashTagMap reviewHashTagMap = ReviewHashTagMapFixture.reviewHashTagMapBuilder();

        //when & then
        assertEquals("테스트 이메일", reviewHashTagMap.getReview().getMember().getEmail());
        assertEquals("테스트 닉네임", reviewHashTagMap.getReview().getMember().getNickname());
        assertEquals("테스트 프로필 이미지 URL", reviewHashTagMap.getReview().getMember().getProfileImageUrl());
        assertEquals(LocalDate.now(), reviewHashTagMap.getReview().getReviewDate());
        assertEquals(PlaceStatus.BLOOMING, reviewHashTagMap.getReview().getPlaceStatus());
        assertEquals("테스트 리뷰 내용", reviewHashTagMap.getReview().getReviewContent());
        assertEquals("테스트 해시 태그", reviewHashTagMap.getHashTag().getName());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("여러 개의 리뷰와 해시태그 매핑을 성공적으로 생성할 수 있다.")
    void createReviewHashTagMaps_Success(int count) {
        //given
        List<ReviewHashTagMap> reviewHashTagMaps = ReviewHashTagMapFixture.reviewHashTagMapsBuilder(count);

        //when & then
        assertEquals(count, reviewHashTagMaps.size());

        IntStream.range(0, count).forEach(i -> {
            ReviewHashTagMap reviewHashTagMap = reviewHashTagMaps.get(i);
            assertEquals(String.format("테스트 해시 태그 %d", i), reviewHashTagMap.getHashTag().getName());
        });
    }
}
