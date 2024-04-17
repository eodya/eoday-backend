package com.eodya.backend.fixture.domain;

import com.eodya.backend.member.domain.Member;
import com.eodya.backend.place.domain.Place;
import com.eodya.backend.place.domain.PlaceStatus;
import com.eodya.backend.review.domain.Review;
import com.eodya.backend.review.domain.ReviewImage;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

public class ReviewFixture {

    public static Review reviewBuild() {
        Member member = MemberFixture.memberBuild();
        LocalDate reviewDate = LocalDate.now();
        PlaceStatus placeStatus = PlaceStatus.BLOOMING;
        String reviewContent = "테스트 리뷰 내용";
        Place place = PlaceFixture.placeBuild(member);

        return Review.builder()
                .reviewDate(reviewDate)
                .placeStatus(placeStatus)
                .reviewContent(reviewContent)
                .place(place)
                .member(member)
                .build();
    }

    public static List<Review> reviewsBuild(int count, Member member) {
        return IntStream.range(0, count)
                .mapToObj(i -> Review.builder()
                        .reviewDate(LocalDate.now())
                        .placeStatus(PlaceStatus.BLOOMING)
                        .reviewContent(String.format("테스트 리뷰 내용 %d", i))
                        .place(PlaceFixture.placeBuild(member))
                        .member(member)
                        .build())
                .toList();
    }

    public static ReviewImage reviewImageBuild(Review review) {
        return ReviewImage.builder()
                .imageUrl("http://example.com/image.jpg")
                .review(review)
                .build();
    }

    public static List<ReviewImage> reviewImagesBuild(Review review, int imageCount) {
        return IntStream.range(0, imageCount)
                .mapToObj(i -> ReviewImage.builder()
                        .imageUrl(String.format("http://example.com/image%d.jpg", i))
                        .review(review)
                        .build())
                .toList();
    }
}
