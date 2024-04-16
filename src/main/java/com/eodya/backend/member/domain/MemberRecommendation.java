package com.eodya.backend.member.domain;

import com.eodya.backend.place.domain.Place;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class MemberRecommendation {

    @OneToMany(mappedBy = "member", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Place> memberRecommendation = new ArrayList<>();

    public void addMemberRecommendation(Place place) {
        memberRecommendation.add(place);
    }
}
