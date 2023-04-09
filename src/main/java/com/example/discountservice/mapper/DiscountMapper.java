package com.example.discountservice.mapper;

import com.example.discountservice.config.MappersConfig;
import com.example.discountservice.controller.dto.check.CheckRequest;
import com.example.discountservice.entity.CheckEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;


@Mapper(config = MappersConfig.class, uses = CheckPositionMapper.class)
public interface DiscountMapper {

    List<CheckEntity> checkDtoListToChecksEntity(Set<CheckRequest> checks);

    @Mapping(target = "client", ignore = true)
    @Mapping(target = "checkPositionEntities", source = "positions")
    CheckEntity checkDtoToChecksEntity (CheckRequest checkRequest);
}
