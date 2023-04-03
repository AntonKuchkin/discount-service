package com.example.discountservice.service.api;

import com.example.discountservice.entity.CheckEntity;

public interface CheckService {

    public boolean checkingForPresenceInTheDatabase(CheckEntity check);
}
