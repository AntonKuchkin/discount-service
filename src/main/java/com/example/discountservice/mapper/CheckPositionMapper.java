package com.example.discountservice.mapper;

import com.example.discountservice.config.MappersConfig;
import com.example.discountservice.controller.dto.check.CheckPositionRequest;
import com.example.discountservice.entity.CheckPositionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MappersConfig.class)
public interface CheckPositionMapper {

    @Mapping(target = "positionSum", source = "positionAmount")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "checkEntity", ignore = true)
    CheckPositionEntity positionDtoToPositionEntity(CheckPositionRequest position);
}
