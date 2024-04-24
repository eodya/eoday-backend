package com.eodya.backend.fixture.domain;

import com.eodya.backend.address.domain.AddressDepth1;
import com.eodya.backend.address.domain.AddressDepth2;
import com.eodya.backend.member.domain.Member;
import com.eodya.backend.place.domain.Place;
import com.eodya.backend.place.domain.PlaceImage;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import java.util.List;
import java.util.stream.IntStream;

import static com.eodya.backend.place.domain.PlaceStatus.*;

public class PlaceFixture {

    private static final GeometryFactory geometryFactory = new GeometryFactory();

    public static Place placeBuild(Member member) {
        Point point = pointBuild(37.5665, 126.9780);
        String name = "테스트 장소";
        String addressDetail = "서울특별시 강남구 논현동";
        AddressDepth1 addressDepth1 = AddressDepthFixture.addressDepth1Build();
        AddressDepth2 addressDepth2 = AddressDepthFixture.addressDepth2Build(addressDepth1);

        return Place.builder()
                .point(point)
                .name(name)
                .addressDetail(addressDetail)
                .member(member)
                .placeStatus(BLOOMING)
                .addressDepth1(addressDepth1)
                .addressDepth2(addressDepth2)
                .build();
    }

    public static List<Place> placesBuild(int count, Member member) {
        return IntStream.range(0, count)
                .mapToObj(i -> Place.builder()
                        .point(pointBuild(37.5665, 126.9780))
                        .name(String.format("테스트 장소 %d", i))
                        .addressDetail(String.format("서울특별시 강남구 논현동 %d", i))
                        .member(member)
                        .placeStatus(BLOOMING)
                        .addressDepth1(AddressDepthFixture.addressDepth1Build())
                        .addressDepth2(AddressDepthFixture.addressDepth2Build(AddressDepthFixture.addressDepth1Build()))
                        .build())
                .toList();
    }

    public static PlaceImage placeImageBuild(Place place) {
        return PlaceImage.builder()
                .imageUrl("http://example.com/image.jpg")
                .place(place)
                .build();
    }

    public static List<PlaceImage> placeImagesBuild(Place place, int imageCount) {
        return IntStream.range(0, imageCount)
                .mapToObj(i -> PlaceImage.builder()
                        .imageUrl(String.format("http://example.com/image%d.jpg", i))
                        .place(place)
                        .build())
                .toList();
    }

    public static Point pointBuild(double x, double y) {
        Coordinate coordinate = new Coordinate(x, y);
        return geometryFactory.createPoint(coordinate);
    }
}
