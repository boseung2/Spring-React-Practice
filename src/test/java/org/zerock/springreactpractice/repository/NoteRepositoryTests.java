package org.zerock.springreactpractice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.springreactpractice.entity.ClubMember;
import org.zerock.springreactpractice.entity.Note;

@SpringBootTest
public class NoteRepositoryTests {

    @Autowired
    NoteRepository noteRepository;

    @Test
    public void testRead() {
        System.out.println(noteRepository.getWithWriter(2L));
    }

    @Test
    public void testRegister() {
        Note note = Note.builder()
                .title("Test 2")
                .content("Test Content 2")
                .writer(ClubMember.builder().email("user10@zerock.org").build())
                .build();

        System.out.println(noteRepository.save(note));

    }
}
