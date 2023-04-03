package com.example.discountservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false)
    private UUID Id;

    @Column(name = "card_number", nullable = false)
    @Length(min = 20, max = 20)
    private String cardNumber;

    @Column(name = "number_of_points", nullable = false)
    private Integer numberOfPoints;

    @OneToMany(mappedBy = "client", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<CheckEntity> checkEntities;
}
