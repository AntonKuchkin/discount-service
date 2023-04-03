package com.example.discountservice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "check_position")
public class CheckPositionEntity {

    @Id
    @Column(name = "id_check", nullable = false)
    private UUID idCheck;

    @Column(name = "position_amount", nullable = false)
    private Integer positionAmount;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "check_id", nullable = false)
    private CheckEntity checkEntity;
}
