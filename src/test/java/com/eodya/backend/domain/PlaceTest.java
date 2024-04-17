package com.eodya.backend.domain;

import com.eodya.backend.fixture.domain.MemberFixture;
import com.eodya.backend.fixture.domain.PlaceFixture;
import com.eodya.backend.member.domain.Member;
import com.eodya.backend.place.domain.Place;
import com.eodya.backend.place.domain.PlaceImage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.locationtech.jts.geom.Point;

import java.util.List;
import java.util.stream.IntStream;

import static com.eodya.backend.place.domain.PlaceStatus.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class PlaceTest {

    @Test
    @DisplayName("정상적으로 장소를 생성할 수 있다.")
    void createPlace_Success() {
        //given
        Member member = MemberFixture.memberBuild();
        Place place = PlaceFixture.placeBuild(member);

        //when
        Point point = place.getPoint();

        //when & then
        assertEquals(37.5665, point.getX(), 0.0001);
        assertEquals(126.9780, point.getY(), 0.0001);
        assertEquals("테스트 장소", place.getName());
        assertEquals("서울특별시 강남구 논현동", place.getAddressDetail());
        assertEquals(0, place.getReviewCount());
        assertEquals(0, place.getBookmarkCount());
        assertEquals(member, place.getMember());
        assertEquals(BLOOMING, place.getPlaceStatus());
        assertEquals("서울시", place.getAddressDepth1().getName());
        assertEquals("강남구", place.getAddressDepth2().getName());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("여러 개의 장소를 성공적으로 생성할 수 있다.")
    void createPlaces_Success(int count) {
        //given
        Member member = MemberFixture.memberBuild();
        List<Place> places = PlaceFixture.placesBuild(count, member);

        //when & then
        assertEquals(count, places.size());

        IntStream.range(0, count).forEach(i -> {
            Place place = places.get(i);
            Point point = place.getPoint();
            assertEquals(37.5665, point.getX(), 0.0001);
            assertEquals(126.9780, point.getY(), 0.0001);
            assertEquals(String.format("테스트 장소 %d", i), place.getName());
            assertEquals(String.format("서울특별시 강남구 논현동 %d", i), place.getAddressDetail());
            assertEquals(member, place.getMember());
            assertEquals(BLOOMING, place.getPlaceStatus());
            assertEquals(0, place.getReviewCount());
            assertEquals(0, place.getBookmarkCount());
            assertEquals("서울시", place.getAddressDepth1().getName());
            assertEquals("강남구", place.getAddressDepth2().getName());
        });
    }

    @Test
    @DisplayName("이미지를 추가하여 장소를 생성할 수 있다.")
    void createPlaceWithImages_Success() {
        //given
        Member member = MemberFixture.memberBuild();
        Place place = PlaceFixture.placeBuild(member);
        PlaceImage placeImage = PlaceFixture.placeImageBuild(place);

        //when & then
        assertEquals("http://example.com/image.jpg", placeImage.getImageUrl());
        assertSame(place, placeImage.getPlace());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("이미지를 추가하여 여러 개의 장소를 생성할 수 있다.")
    void createPlacesWithImages_Success(int count) {
        //given
        Member member = MemberFixture.memberBuild();
        Place place = PlaceFixture.placeBuild(member);
        List<PlaceImage> placeImages = PlaceFixture.placeImagesBuild(place, count);

        //when & then
        IntStream.range(0, count).forEach(i -> {
            assertEquals(String.format("http://example.com/image%d.jpg", i), placeImages.get(i).getImageUrl());
            assertSame(place, placeImages.get(i).getPlace());
        });
    }
}
