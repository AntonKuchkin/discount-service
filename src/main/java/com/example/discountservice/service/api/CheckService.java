package com.example.discountservice.service.api;

import com.example.discountservice.entity.CheckEntity;
import lombok.NonNull;

public interface CheckService {

    /**
     * Проверка если такой чек в БД
     *
     * @param check - чек
     * @return - возвращает true если чек отсутствует в бд,
     * false - если есть.
     */
    boolean checkingForPresenceInTheDatabase(@NonNull CheckEntity check);
}
