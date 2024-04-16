package com.eodya.backend.member.domain;

import com.eodya.backend.review.domain.Review;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class MemberReview {

    @OneToMany(mappedBy = "member", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Review> memberReviews = new ArrayList<>();

    public void addMemberReview(Review review) {
        memberReviews.add(review);
    }
}
