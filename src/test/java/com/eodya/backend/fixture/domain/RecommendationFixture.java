package com.eodya.backend.fixture.domain;

import com.eodya.backend.member.domain.Member;
import com.eodya.backend.place.domain.Place;
import com.eodya.backend.recommendation.domain.Recommendation;

import java.util.List;
import java.util.stream.IntStream;

public class RecommendationFixture {

    public static Recommendation recommendationBuilder() {
        Member member = MemberFixture.memberBuild();
        Place place = PlaceFixture.placeBuild(member);

        return Recommendation.builder()
                .review(ReviewFixture.reviewBuild())
                .place(place)
                .build();
    }

    public static List<Recommendation> recommendationsBuilder(int count, Member member) {
        return IntStream.range(0, count)
                .mapToObj(i -> Recommendation.builder()
                        .review(ReviewFixture.reviewBuild())
                        .place(PlaceFixture.placeBuild(member))
                        .build())
                .toList();
    }
}
