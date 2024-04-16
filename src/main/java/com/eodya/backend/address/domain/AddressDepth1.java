package com.eodya.backend.address.domain;

import com.eodya.backend.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Entity
@Table(name = "address_depth1")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressDepth1 extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 30)
    private String name;

    @Builder
    private AddressDepth1(String name) {
        this.name = name;
    }
}

