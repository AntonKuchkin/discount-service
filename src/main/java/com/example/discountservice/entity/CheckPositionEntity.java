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

@Getter
@Setter
@Entity
@Table(name = "check_position")
public class CheckPositionEntity {

    @Id
    @Column(name = "id_position", nullable = false)
    private Long id;

    @Column(name = "position_amount", nullable = false)
    private Integer positionSum;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "check_id", nullable = false)
    private CheckEntity checkEntity;
}
