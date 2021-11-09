package io.swagger.client;

import io.swagger.client.api.PetApi;

public class TestApi {

    public static void main(String[] args) throws ApiException {
        var apiClient = new PetApi();

        var response = apiClient.getAllPets();

        System.out.println(response);
    }
}