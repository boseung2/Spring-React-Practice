package org.zerock.springreactpractice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NoteServiceTests {

    @Autowired
    NoteService noteService;

    @Test
    public void readTest() {
        System.out.println(noteService.get(2L));
    }
}
