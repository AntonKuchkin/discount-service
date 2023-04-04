package com.example.discountservice.service.impl;

import com.example.discountservice.entity.CheckEntity;
import com.example.discountservice.repository.CheckRepository;
import com.example.discountservice.service.api.CheckService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckServiceImpl implements CheckService {

    private final CheckRepository checkRepository;

    public boolean checkingForPresenceInTheDatabase(@NonNull CheckEntity check) {
        if(checkRepository.findById(check.getId()).isEmpty()){
            checkRepository.save(check);
            return true;
        }
        return false;
    }
}
