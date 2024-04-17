package com.eodya.backend.domain;

import com.eodya.backend.fixture.domain.HashTagFixture;
import com.eodya.backend.review.domain.HashTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashTagTest {

    @Test
    @DisplayName("정상적으로 해시태그를 생성할 수 있다.")
    void createHashTag_Success() {
        //given
        HashTag hashTag = HashTagFixture.hashTagBuild();

        //when & then
        assertEquals("테스트 해시 태그", hashTag.getName());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("여러 개의 해시태그를 성공적으로 생성할 수 있다.")
    void createHashTags_Success(int count) {
        //given
        List<HashTag> hashTags = HashTagFixture.hashTagsBuilder(count);

        //when & then
        IntStream.range(0, count).forEach(i -> {
            HashTag hashTag = hashTags.get(i);
            assertEquals(String.format("테스트 해시 태그 %d", i), hashTag.getName());
        });
    }
}
