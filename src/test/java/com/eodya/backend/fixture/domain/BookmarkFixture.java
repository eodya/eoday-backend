package com.eodya.backend.fixture.domain;

import com.eodya.backend.bookmark.domain.Bookmark;
import com.eodya.backend.member.domain.Member;
import com.eodya.backend.place.domain.Place;

import java.util.List;
import java.util.stream.IntStream;

public class BookmarkFixture {

    public static Bookmark bookmarkBuilder() {
        Member member = MemberFixture.memberBuild();
        Place place = PlaceFixture.placeBuild(member);

        return Bookmark.builder()
                .place(place)
                .member(member)
                .build();
    }

    public static List<Bookmark> bookmarksBuilder(int count, Member member) {
        List<Place> places = PlaceFixture.placesBuild(count, member);

        return IntStream.range(0, count)
                .mapToObj(i -> {
                    Place place = places.get(i % places.size());
                    return Bookmark.builder()
                            .member(member)
                            .place(place)
                            .build();
                })
                .toList();
    }
}
