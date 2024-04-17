package com.eodya.backend.fixture.domain;

import com.eodya.backend.member.domain.Member;
import com.eodya.backend.place.domain.Place;
import com.eodya.backend.review.domain.HashTag;
import com.eodya.backend.review.domain.Review;
import com.eodya.backend.review.domain.ReviewHashTagMap;

import java.util.List;
import java.util.stream.IntStream;

public class ReviewHashTagMapFixture {

    public static ReviewHashTagMap reviewHashTagMapBuilder() {
        Review review = ReviewFixture.reviewBuild();
        HashTag hashTag = HashTagFixture.hashTagBuild();

        return ReviewHashTagMap.builder()
                .review(review)
                .hashTag(hashTag)
                .build();
    }

    public static List<ReviewHashTagMap> reviewHashTagMapsBuilder(int count) {
        List<HashTag> hashTags = HashTagFixture.hashTagsBuilder(count);

        return IntStream.range(0, count)
                .mapToObj(i -> {
                    HashTag hashTag = hashTags.get(i % hashTags.size());
                    return ReviewHashTagMap.builder()
                            .review(ReviewFixture.reviewBuild())
                            .hashTag(hashTag)
                            .build();
                })
                .toList();
    }
}
