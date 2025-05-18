package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void testMapToCardDto() {

        //Given
        TrelloCard trelloCard = new TrelloCard("Test", "testing MapToCardDto", "2", "1");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("Test", trelloCardDto.getName());
        assertEquals("testing MapToCardDto", trelloCardDto.getDescription());
        assertEquals("2", trelloCardDto.getPos());
        assertEquals("1", trelloCardDto.getListId());

    }

    @Test
    void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test", "testing MapToCardDto", "2", "1");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("Test", trelloCard.getName());
        assertEquals("testing MapToCardDto", trelloCard.getDescription());
        assertEquals("2", trelloCard.getPos());
        assertEquals("1", trelloCard.getListId());
    }

    @Test
    void testMapToListDto() {

        //Given
        TrelloList list1 = new TrelloList("1", "test1", true);
        TrelloList list2 = new TrelloList();
        TrelloList list3 = new TrelloList("3", "test3", false);
        List<TrelloList> lists = List.of(list1, list2, list3);

        //When
        List<TrelloListDto> listsDto = trelloMapper.mapToListDto(lists);

        //Then
        assertEquals("1", listsDto.get(0).getId());
        assertEquals("test1", listsDto.get(0).getName());
        assertEquals(null, listsDto.get(1).getId());
        assertEquals("3", listsDto.get(2).getId());
        assertEquals("test3", listsDto.get(2).getName());
        assertEquals(3, listsDto.size());

    }

    @Test
    void testMapToList() {

        //Given
        TrelloListDto list1 = new TrelloListDto("1", "test1", true);
        TrelloListDto list2 = new TrelloListDto("2", "test2", false);
        TrelloListDto list3 = new TrelloListDto("3", "test3", false);
        List<TrelloListDto> listsDto = List.of(list1, list2, list3);

        //When
        List<TrelloList> lists = trelloMapper.mapToList(listsDto);

        //Then
        assertEquals("1", lists.get(0).getId());
        assertEquals("test1", lists.get(0).getName());
        assertEquals("2", lists.get(1).getId());
        assertEquals("3", lists.get(2).getId());
        assertEquals("test3", lists.get(2).getName());
        assertEquals(3, lists.size());

    }

    @Test
    void testMapToBoards() {

        //Given
        TrelloListDto list1 = new TrelloListDto("1", "test1", true);
        TrelloListDto list2 = new TrelloListDto("2", "test2", false);
        TrelloListDto list3 = new TrelloListDto("3", "test3", false);
        List<TrelloListDto> listsDto = List.of(list1, list2, list3);

        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "test1", listsDto);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "test2", new ArrayList<>());
        TrelloBoardDto trelloBoardDto3 = new TrelloBoardDto("3", "test3", new ArrayList<>() );
        List<TrelloBoardDto> listDto = List.of(trelloBoardDto1, trelloBoardDto2, trelloBoardDto3);

        //When
        List<TrelloBoard> list = trelloMapper.mapToBoards(listDto);

        //Then
        assertEquals("1", list.get(0).getId());
        assertEquals("test1", list.get(0).getName());
        assertEquals("test3", list.get(0).getLists().get(2).getName());
        assertEquals("3", list.get(2).getId());
        assertEquals(3, list.size());

    }

    @Test
    void testMapToBoardsDto() {

        //Given
        TrelloList list1 = new TrelloList("1", "test1", true);
        TrelloList list2 = new TrelloList("2", "test2", false);
        TrelloList list3 = new TrelloList("3", "test3", false);
        List<TrelloList> lists = List.of(list1, list2, list3);

        TrelloBoard trelloBoard1 = new TrelloBoard("1", "test1", lists);
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "test2", new ArrayList<>());
        TrelloBoard trelloBoard3 = new TrelloBoard("3", "test3", new ArrayList<>() );
        List<TrelloBoard> list = List.of(trelloBoard1, trelloBoard2, trelloBoard3);

        //When
        List<TrelloBoardDto> listDto = trelloMapper.mapToBoardsDto(list);

        //Then
        assertEquals("1", listDto.get(0).getId());
        assertEquals("test1", listDto.get(0).getName());
        assertEquals("test3", listDto.get(0).getLists().get(2).getName());
        assertEquals("3", listDto.get(2).getId());
        assertEquals(3, listDto.size());

    }

}