package com.example.discountservice.service;

import com.example.discountservice.service.api.ClientService;
import com.example.discountservice.utils.TestDataUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ClientServiceTest extends BaseIntegrationTest {

    @Autowired
    ClientService clientService;

    private UUID Id = UUID.randomUUID();

//    @Test
//    void getClientByIdThatDoesntExistTest() throws Exception {
//        String urlTemplate = "/client-service/id/" + Id;
//        mockMvc.perform(get(urlTemplate))
//                .andExpect(status().isNotFound());
//    }

    @Test
    void createClientTest () throws Exception {
        String urlTemplate = "/client-service/new";

        String body = TestDataUtils.getJsonTestObjectAsString("client/create_client_new.json");

        mockMvc.perform(post(urlTemplate).contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isCreated());

    }
}
