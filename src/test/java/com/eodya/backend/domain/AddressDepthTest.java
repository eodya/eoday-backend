package com.eodya.backend.domain;

import com.eodya.backend.address.domain.AddressDepth1;
import com.eodya.backend.address.domain.AddressDepth2;
import com.eodya.backend.fixture.domain.AddressDepthFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressDepthTest {

    @Test
    @DisplayName("정상적으로 '시'를 생성할 수 있다.")
    void createAddressDepth1_Success() {
        //given
        AddressDepth1 addressDepth1 = AddressDepthFixture.addressDepth1Build();

        //when & then
        assertEquals("서울시", addressDepth1.getName());

    }

    @Test
    @DisplayName("정상적으로 '구'를 생성할 수 있다.")
    void createAddressDepth2_Success() {
        //given
        AddressDepth1 addressDepth1 = AddressDepthFixture.addressDepth1Build();
        AddressDepth2 addressDepth2 = AddressDepthFixture.addressDepth2Build(addressDepth1);

        // when & then
        assertEquals("서울시", addressDepth1.getName());
        assertEquals("강남구", addressDepth2.getName());
    }
}
