package com.eodya.backend.review.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class ReviewRecommendation {

    @OneToMany(mappedBy = "review", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Review> reviewRecommendation = new ArrayList<>();

    public void addMemberRecommendation(Review review) {
        reviewRecommendation.add(review);
    }
}
