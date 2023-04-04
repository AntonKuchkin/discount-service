package com.example.discountservice.mapper;

import com.example.discountservice.config.MappersConfig;
import com.example.discountservice.controller.dto.client.ClientCreateRequest;
import com.example.discountservice.controller.dto.client.ClientResponse;
import com.example.discountservice.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MappersConfig.class)
public interface ClientMapper {

    @Mapping(target = "numberOfPoints", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "checkEntities", ignore = true)
    ClientEntity clientDtoRequestToClientEntity (ClientCreateRequest client);

    @Mapping(target = "sum", source = "numberOfPoints")
    ClientResponse clientEntityToClientResponse (ClientEntity client);
}
