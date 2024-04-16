package com.eodya.backend.place.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Entity
@Table(name = "place_hashtag_map")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlaceHashTagMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hash_tag_id")
    private HashTag hashTag;

    @Builder
    private PlaceHashTagMap(
            Place place,
            HashTag hashTag
    ) {
        this.place = place;
        this.hashTag = hashTag;
    }
}
