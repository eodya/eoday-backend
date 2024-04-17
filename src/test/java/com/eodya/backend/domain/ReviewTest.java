package com.eodya.backend.domain;

import com.eodya.backend.fixture.domain.MemberFixture;
import com.eodya.backend.fixture.domain.ReviewFixture;
import com.eodya.backend.member.domain.Member;
import com.eodya.backend.place.domain.PlaceStatus;
import com.eodya.backend.review.domain.Review;
import com.eodya.backend.review.domain.ReviewImage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class ReviewTest {

    @Test
    @DisplayName("정상적으로 사진없이 리뷰를 생성할 수 있다.")
    void createReview_WithoutReviewImage_Success() {
        //given
        Review review = ReviewFixture.reviewBuild();

        //when & then
        assertEquals(LocalDate.now(), review.getReviewDate());
        assertEquals(PlaceStatus.BLOOMING, review.getPlaceStatus());
        assertEquals("테스트 리뷰 내용", review.getReviewContent());
        assertEquals("테스트 장소", review.getPlace().getName());
        assertEquals("서울특별시 강남구 논현동", review.getPlace().getAddressDetail());
        assertEquals("테스트 이메일", review.getMember().getEmail());
        assertEquals("테스트 닉네임", review.getMember().getNickname());
        assertEquals("테스트 프로필 이미지 URL", review.getMember().getProfileImageUrl());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("정상적으로 사진이 없는 여러 개의 리뷰를 성공적으로 생성할 수 있다.")
    void createReviews_WithoutReviewImage_Success(int count) {
        //given
        Member member = MemberFixture.memberBuild();
        List<Review> reviews = ReviewFixture.reviewsBuild(count, member);

        //when & then
        assertEquals(count, reviews.size());

        IntStream.range(0, count).forEach(i -> {
            Review review = reviews.get(i);
            assertEquals(LocalDate.now(), review.getReviewDate());
            assertEquals(PlaceStatus.BLOOMING, review.getPlaceStatus());
            assertEquals(String.format("테스트 리뷰 내용 %d", i), review.getReviewContent());
            assertEquals(String.format("테스트 리뷰 내용 %d", i), review.getReviewContent());
            assertEquals("테스트 장소", review.getPlace().getName());
            assertEquals("서울특별시 강남구 논현동", review.getPlace().getAddressDetail());
            assertEquals("테스트 이메일", review.getMember().getEmail());
            assertEquals("테스트 닉네임", review.getMember().getNickname());
            assertEquals("테스트 프로필 이미지 URL", review.getMember().getProfileImageUrl());
        });
    }

    @Test
    @DisplayName("정상적으로 사진을 첨부하여 리뷰를 생성할 수 있다.")
    void createReview_WithReviewImage_Success() {
        //given
        Review review = ReviewFixture.reviewBuild();
        ReviewImage reviewImage = ReviewFixture.reviewImageBuild(review);

        //when & then
        assertEquals("http://example.com/image.jpg", reviewImage.getImageUrl());
        assertSame(review, reviewImage.getReview());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("정상적으로 사진이 있는 여러 개의 리뷰를 성공적으로 생성할 수 있다.")
    void createReviews_WithReviewImage_Success(int count) {
        //given
        Review review = ReviewFixture.reviewBuild();
        List<ReviewImage> reviewImages = ReviewFixture.reviewImagesBuild(review, count);

        //when & then
        IntStream.range(0, count).forEach(i -> {
            assertEquals(String.format("http://example.com/image%d.jpg", i), reviewImages.get(i).getImageUrl());
            assertSame(review, reviewImages.get(i).getReview());
        });
    }
}
