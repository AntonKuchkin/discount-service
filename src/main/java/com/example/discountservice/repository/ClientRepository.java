package com.example.discountservice.repository;

import com.example.discountservice.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {

    ClientEntity findByCardNumber(String cardNumber);
}
