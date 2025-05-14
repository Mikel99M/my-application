package com.crud.tasks.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrelloConfigTest {

    @Test
    void getTrelloApiEndpoint() {
        TrelloConfig trelloConfig = new TrelloConfig();

        System.out.println(trelloConfig.getTrelloApiEndpoint());
        System.out.println("username: " + trelloConfig.getTrelloUsername());
    }

    @Test
    void getTrelloAppKey() {
    }

    @Test
    void getTrelloToken() {
    }

    @Test
    void getTrelloUsername() {
    }
}