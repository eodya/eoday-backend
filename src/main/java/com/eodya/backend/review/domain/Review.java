package com.eodya.backend.review.domain;

import com.eodya.backend.common.entity.BaseEntity;
import com.eodya.backend.member.domain.Member;
import com.eodya.backend.place.domain.Place;
import com.eodya.backend.place.domain.PlaceStatus;
import com.eodya.backend.place.util.PlaceStatusConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "review")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate reviewDate;

    @NotNull
    @Column(length = 1000)
    private String reviewContent;

    @NotNull
    @Convert(converter = PlaceStatusConverter.class)
    @Column(name = "place_status", length = 50)
    private PlaceStatus placeStatus;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Embedded
    private ReviewRecommendation reviewRecommendation = new ReviewRecommendation();

    @Builder
    private Review(
            LocalDate reviewDate,
            String reviewContent,
            PlaceStatus placeStatus,
            Place place,
            Member member
    ) {
        this.reviewDate = reviewDate;
        this.reviewContent = reviewContent;
        this.placeStatus = placeStatus;
        this.place = place;
        this.member = member;
    }
}
