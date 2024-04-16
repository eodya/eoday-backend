package com.eodya.backend.member.domain;

import com.eodya.backend.bookmark.domain.Bookmark;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class MemberBookmark {

    @OneToMany(mappedBy = "member", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Bookmark> memberBookmark = new ArrayList<>();

    public void addMemberBookmark(Bookmark bookmark) {
        memberBookmark.add(bookmark);
    }
}
