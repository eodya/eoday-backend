package com.eodya.backend.fixture.domain;

import com.eodya.backend.review.domain.HashTag;

import java.util.List;
import java.util.stream.IntStream;

public class HashTagFixture {

    public static HashTag hashTagBuild() {
        return HashTag.builder()
                .name("테스트 해시 태그")
                .build();
    }

    public static List<HashTag> hashTagsBuilder(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> HashTag.builder()
                        .name(String.format("테스트 해시 태그 %d", i))
                        .build())
                .toList();
    }
}
