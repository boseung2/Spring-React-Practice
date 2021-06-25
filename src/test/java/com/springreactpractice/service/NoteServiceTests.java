package com.springreactpractice.service;

import com.springreactpractice.dto.NoteDTO;
import com.springreactpractice.entity.Note;
import com.springreactpractice.repository.NoteRepository;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class NoteServiceTests {

    @Autowired
    NoteService noteService;

    NoteDTO sampleDTO;

    List<NoteDTO> sampleDTOs = new ArrayList<>();

    @BeforeEach
    public void initialSet() {

        sampleDTO = NoteDTO.builder()
                .title("noteService test title")
                .content("noteService test content")
                .writerEmail("user1@naver.com")
                .build();

        IntStream.rangeClosed(1, 3).forEach(i -> {

            sampleDTOs.add(NoteDTO.builder()
                    .title("noteService test title")
                    .content("noteService test content")
                    .writerEmail("user10@naver.com")
                    .build());

        });

    }

    @Test
    public void registerAndReadAndDeleteTest() {

        // sampleDTO 등록
        Long num = noteService.register(sampleDTO);

        System.out.println(num);

        // num 으로 조회 한 다음 sampleDTO 와 같은지 비교
        NoteDTO result = noteService.get(num);

        compareNoteDTO(result, sampleDTO);

        // num 으로 삭제 한 다음 삭제되었는지 확인
        noteService.remove(num);

        assert(noteService.get(num) == null);

    }

    @Test
    public void registerTest2() {

        // content 가 빠진 dto
        NoteDTO strangeDTO = NoteDTO.builder()
                .title("noteService test title")
                .writerEmail("user1@naver.com")
                .build();

        // strangeDTO 등록 무슨 Exception 으로 받을지? 지금은 정상 등록됨
        try {
            //Long num = noteService.register(strangeDTO);
            //System.out.println(num);

        } catch(Exception e) {
            e.printStackTrace();
            //assert(e.getClass().equals(Exception.class));
        }

    }

    @Test
    public void registerTest3() {

        // writerEmail 이 빠진 dto
        NoteDTO strangeDTO = NoteDTO.builder()
                .title("noteService test title")
                .content("noteService test content")
                .build();

        // strangeDTO 등록 InvalidDataAccessApiUsageException 발생 확인
        try {
            Long num = noteService.register(strangeDTO);
        } catch(Exception e) {
            System.out.println(e.getClass());
            assert(e.getClass().equals(InvalidDataAccessApiUsageException.class));
        }

    }

    @Test
    public void testUpdate() {

        // sampleDTO 등록
        Long num = noteService.register(sampleDTO);

        // num 으로 조회 한 다음 sampleDTO 와 같은지 비교
        NoteDTO result = noteService.get(num);

        compareNoteDTO(result, sampleDTO);

        // sampleDTO 수정 해서 등록
        sampleDTO.setNum(num);
        sampleDTO.setTitle("serviceTest modify title");
        sampleDTO.setContent("serviceTest modify content");

        noteService.modify(sampleDTO);

        // num 으로 조회 한 다음 수정한 sampleDTO 와 같은지 비교
        result = noteService.get(num);

        compareNoteDTO(result, sampleDTO);

        // num 으로 삭제 한 다음 삭제되었는지 확인
        noteService.remove(num);

        assert(noteService.get(num) == null);

    }

    @Test
    public void testGetAllWithWriter() {

        // sampleDTOs 3개 등록 한 뒤 num 저장하고 조회해서 제대로 들어갔는지 확인
        sampleDTOs.forEach(dto -> {
            Long num = noteService.register(dto);
            dto.setNum(num);

            NoteDTO result = noteService.get(num);
            compareNoteDTO(result, dto);
        });

        // writer 로 note 불러 온 다음 sampleDTOs 와 같은지 확인
        List<NoteDTO> result = noteService.getAllWithWriter(sampleDTOs.get(0).getWriterEmail());

        IntStream.rangeClosed(0, 2).forEach(i -> {
            compareNoteDTO(sampleDTOs.get(i), result.get(i));
        });

        // 저장한 sampleDTOs 삭제한 후 빈 list 인지 확인
        sampleDTOs.forEach(dto -> {
            noteService.remove(dto.getNum());
        });

        assert(noteService.getAllWithWriter(sampleDTOs.get(0).getWriterEmail()).isEmpty());

    }

    private void compareNoteDTO(NoteDTO dto1, NoteDTO dto2) {
        assert(dto1.getTitle().equals(dto2.getTitle()));
        assert(dto1.getContent().equals(dto2.getContent()));
        assert(dto1.getWriterEmail().equals(dto2.getWriterEmail()));
    }


}
