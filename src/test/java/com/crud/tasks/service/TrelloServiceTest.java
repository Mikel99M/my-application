package com.crud.tasks.service;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloServiceTest {

//    @Autowired
//    private TrelloService trelloService;
//
//    @Test
//    void fetchTrelloBoards() {
//    }
//
//    @Test
//    void createTrelloCard() {
//        //Given
//        TrelloCardDto trelloCardDto = new TrelloCardDto("test", "testing createTrelloCard", "1", "2" );
//
//        //When
//        CreatedTrelloCardDto result = trelloService.createTrelloCard(trelloCardDto);
//
//        //Then
//        assertNotNull(result);
//        assertEquals("testing createTrelloCard", result.getName());
//
//
//    }


//    public List<TrelloBoardDto> fetchTrelloBoards() {
//        return trelloClient.getTrelloBoards();
//    }
//
//    public CreatedTrelloCardDto createTrelloCard(final TrelloCardDto trelloCardDto) {
//        CreatedTrelloCardDto newCard = trelloClient.createNewCard(trelloCardDto);
//        ofNullable(newCard).ifPresent(card -> emailService.send(
//                Mail.builder()
//                        .mailTo(adminConfig.getAdminMail())
//                        .subject(SUBJECT)
//                        .message("New card: " + trelloCardDto.getName() + " has been created on your Trello account")
//                        .build()
//        ));
//        return newCard;
//    }
}