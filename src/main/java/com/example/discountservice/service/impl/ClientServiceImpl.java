package com.example.discountservice.service.impl;

import com.example.discountservice.controller.dto.client.ClientCreateRequest;
import com.example.discountservice.controller.dto.client.ClientResponse;
import com.example.discountservice.controller.dto.point.PointsResponse;
import com.example.discountservice.entity.ClientEntity;
import com.example.discountservice.exception.ClientNotFoundException;
import com.example.discountservice.mapper.ClientMapper;
import com.example.discountservice.mapper.DiscountMapper;
import com.example.discountservice.repository.ClientRepository;
import com.example.discountservice.service.api.ClientService;
import com.example.discountservice.service.api.ScoringService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.example.discountservice.constant.PointsConstants.POINTS_AT_CREATION;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;
    private final DiscountMapper discountMapper;
    private final ScoringService scoringService;

    @Override
    public void createClient(@NonNull ClientCreateRequest client) {

        ClientEntity clientEntity = clientMapper.clientDtoRequestToClientEntity(client);
        clientEntity.setNumberOfPoints(POINTS_AT_CREATION);
        clientRepository.save(clientEntity);
    }

    @Override
    public void recordingPointsForTheClientByCardNumber(@NonNull String cardNumber, @NonNull Double sum) {

        ClientEntity client = clientRepository.findByCardNumber(cardNumber);
        client.setNumberOfPoints(scoringService.countPoints(sum));
        clientRepository.save(client);
    }

    @Override
    public PointsResponse getPointsById(@NonNull UUID id) {

        return discountMapper.clientEntityToPoints(clientRepository.findById(id)
                .orElseThrow(() -> ClientNotFoundException.createById(id)));
    }

    @Override
    public ClientResponse getClientById(@NonNull UUID id) {

        return clientMapper.clientEntityToClientResponse(clientRepository.findById(id)
                .orElseThrow(() -> ClientNotFoundException.createById(id)));
    }
}
