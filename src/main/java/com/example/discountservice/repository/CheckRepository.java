package com.example.discountservice.repository;

import com.example.discountservice.entity.CheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CheckRepository extends JpaRepository<CheckEntity, UUID> {

}
