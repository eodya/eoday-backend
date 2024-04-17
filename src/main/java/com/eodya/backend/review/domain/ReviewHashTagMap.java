package com.eodya.backend.review.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Entity
@Table(name = "review_hashtag_map")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewHashTagMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hash_tag_id")
    private HashTag hashTag;

    @Builder
    private ReviewHashTagMap(
            Review review,
            HashTag hashTag
    ) {
        this.review = review;
        this.hashTag = hashTag;
    }
}
