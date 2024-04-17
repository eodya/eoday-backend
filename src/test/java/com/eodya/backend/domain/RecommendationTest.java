package com.eodya.backend.domain;

import com.eodya.backend.fixture.domain.MemberFixture;
import com.eodya.backend.fixture.domain.RecommendationFixture;
import com.eodya.backend.member.domain.Member;
import com.eodya.backend.place.domain.PlaceStatus;
import com.eodya.backend.recommendation.domain.Recommendation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecommendationTest {

    @Test
    @DisplayName("정상적으로 생성된 후기에 대해서 추천을 할 수 있다.")
    void createRecommendation_Success() {
        //given
        Recommendation recommendation = RecommendationFixture.recommendationBuilder();

        //when & then
        assertEquals("테스트 장소", recommendation.getPlace().getName());
        assertEquals("서울특별시 강남구 논현동", recommendation.getPlace().getAddressDetail());
        assertEquals(LocalDate.now(), recommendation.getReview().getReviewDate());
        assertEquals(PlaceStatus.BLOOMING, recommendation.getReview().getPlaceStatus());
        assertEquals("테스트 리뷰 내용", recommendation.getReview().getReviewContent());

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("정상적으로 여러 개의 후기에 대해서 추천을 할 수 있다.")
    void createRecommendations_Success(int count) {
        //given
        Member member = MemberFixture.memberBuild();
        List<Recommendation> recommendations = RecommendationFixture.recommendationsBuilder(count, member);

        //when & then
        assertEquals(count, recommendations.size());

        IntStream.range(0, count).forEach(i -> {
            Recommendation recommendation = recommendations.get(i);
            assertEquals("테스트 장소", recommendation.getPlace().getName());
            assertEquals("서울특별시 강남구 논현동", recommendation.getPlace().getAddressDetail());
            assertEquals(LocalDate.now(), recommendation.getReview().getReviewDate());
            assertEquals(PlaceStatus.BLOOMING, recommendation.getReview().getPlaceStatus());
            assertEquals("테스트 리뷰 내용", recommendation.getReview().getReviewContent());
        });
    }

}
