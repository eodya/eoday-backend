package com.eodya.backend.place.domain;

import com.eodya.backend.address.domain.AddressDepth1;
import com.eodya.backend.address.domain.AddressDepth2;
import com.eodya.backend.common.entity.BaseEntity;
import com.eodya.backend.member.domain.Member;
import com.eodya.backend.place.util.PlaceStatusConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.locationtech.jts.geom.*;

@Getter
@Entity
@Table(name = "place")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Place extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(nullable = false)
    private Point point;

    @Column(length = 100, nullable = false)
    private String addressDetail;

    @Column(nullable = false)
    private Integer reviewCount;

    @Column(nullable = false)
    private Integer bookmarkCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_depth1_id", nullable = false, unique = true)
    private AddressDepth1 addressDepth1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_depth2_id",nullable = false)
    private AddressDepth2 addressDepth2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false, unique = true)
    private Member member;

    @Convert(converter = PlaceStatusConverter.class)
    @Column(name = "place_status", length = 50, nullable = false)
    private PlaceStatus placeStatus;

    @Builder
    private Place(
            String name,
            Point point,
            String addressDetail,
            AddressDepth1 addressDepth1,
            AddressDepth2 addressDepth2,
            PlaceStatus placeStatus,
            Member member
    ) {
        this.name = name;
        this.point = point;
        this.reviewCount = 0;
        this.bookmarkCount = 0;
        this.addressDetail = addressDetail;
        this.addressDepth1 = addressDepth1;
        this.addressDepth2 = addressDepth2;
        this.placeStatus = placeStatus;
        this.member = member;
    }
}
