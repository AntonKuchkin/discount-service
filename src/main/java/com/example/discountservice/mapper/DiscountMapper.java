package com.example.discountservice.mapper;

import com.example.discountservice.config.MappersConfig;
import com.example.discountservice.controller.dto.Points;
import com.example.discountservice.controller.dto.check.CheckRequest;
import com.example.discountservice.entity.CheckEntity;
import com.example.discountservice.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;


@Mapper(config = MappersConfig.class)
public interface DiscountMapper {

    @Mapping(target = "sum", source = "numberOfPoints")
    Points clientEntityToPoints(ClientEntity client);

    List<CheckEntity> checkDtoListToChecksEntity(Set<CheckRequest> checks);

    @Mapping(target = "client", ignore = true)
    @Mapping(target = "checkPositionEntities", ignore = true)
    CheckEntity checkDtoToChecksEntity (CheckRequest checkRequest);
}
