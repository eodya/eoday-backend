package com.eodya.backend.member.domain;

import com.eodya.backend.place.domain.Place;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class MemberPlace {

    @OneToMany(mappedBy = "member", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Place> memberPlaces = new ArrayList<>();

    public void addMemberPlace(Place place) {
        memberPlaces.add(place);
    }
}
