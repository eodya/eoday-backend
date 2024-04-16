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
@Table(name = "address_depth2")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressDepth2 extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 50)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_depth1_id")
    private AddressDepth1 addressDepth1;

    @Builder
    public AddressDepth2(String name, AddressDepth1 addressDepth1) {
        this.name = name;
        this.addressDepth1 = addressDepth1;
    }
}
