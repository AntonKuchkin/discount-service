package com.example.discountservice.service;

import com.example.discountservice.controller.dto.client.ClientResponse;
import com.example.discountservice.entity.ClientEntity;
import com.example.discountservice.service.api.ClientService;
import com.example.discountservice.utils.TestDataUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ClientServiceTest extends BaseIntegrationTest {

    @Autowired
    ClientService clientService;

    @Captor
    ArgumentCaptor<ClientEntity> client;

    private UUID Id = UUID.randomUUID();
    private static final String cardNumber = "12345678901234567890";

//    @Test
//    void getClientByIdThatDoesntExistTest() throws Exception {
//        String urlTemplate = "/client-service/id/" + Id;
//        mockMvc.perform(get(urlTemplate))
//                .andExpect(status().isNotFound());
//    }



    @Test
    void clientCaseTest() throws Exception {
        createClientTest();
        ClientResponse clientResponse = getClientByCardNumberTest();
        Assertions.assertEquals(clientResponse.getCardNumber(), cardNumber);

    }

    private void createClientTest () throws Exception {
        String urlTemplate = "/client-service/new";

        String body = TestDataUtils.getJsonTestObjectAsString("client/create_client_new.json");

        mockMvc.perform(post(urlTemplate).contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isCreated());
    }

    private ClientResponse getClientByCardNumberTest() throws Exception{
        String urlTemplate = "/client-service/" + cardNumber;

        String response = mockMvc.perform(get(urlTemplate))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        return getMapper().readValue(response, ClientResponse.class);
    }

}
