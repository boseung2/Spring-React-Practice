package com.springreactpractice.repository;

import com.springreactpractice.entity.Member;
import com.springreactpractice.entity.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class NoteRepositoryTests {

    @Autowired
    NoteRepository noteRepository;

    Note sample;

    List<Note> samples = new ArrayList<>();

    @BeforeEach
    public void initialSet() {

        sample = Note.builder()
                .title("Test")
                .content("Test Content")
                .writer(Member.builder().email("user100@naver.com").build())
                .build();

        IntStream.rangeClosed(1, 3).forEach(i -> {
            Note sampleNote = Note.builder()
                    .title("Test!!!")
                    .content("Test Content")
                    .writer(Member.builder().email("user100@naver.com").build())
                    .build();

            samples.add(sampleNote);
        });

    }

    @Test
    public void testRegister() {

        // sample 저장
        noteRepository.save(sample);

        // sample 읽어서 같은지 확인 (writer 은 lazy 여서 제외)
        Optional<Note> noteResult = noteRepository.getWithWriter(sample.getNum());

        if(noteResult.isPresent()) {
            System.out.println("sample : " + sample);
            System.out.println("noteResult.get() : " + noteResult.get());
            compareNote(sample, noteResult.get());
        }

        // sample 테스트 내용 지우고 지워졌는지 확인
        noteRepository.deleteById(sample.getNum());

        noteResult = noteRepository.getWithWriter(sample.getNum());
        assert(!noteResult.isPresent());

    }

    @Test
    public void testModify() {

        // sample 저장
        noteRepository.save(sample);

        // sample 불러와서 확인
        Optional<Note> result = noteRepository.getWithWriter(sample.getNum());

        if(result.isPresent()) {
            compareNote(sample, result.get());
        }

        // sample 수정
        sample.changeContent("수정된 내용");
        sample.changeTitle("수정된 제목");

        noteRepository.save(sample);

        // 수정된 sample 불러와서 확인
        result = noteRepository.getWithWriter(sample.getNum());
        if(result.isPresent()) {
            System.out.println(sample);
            System.out.println(result.get());
            compareNote(sample, result.get());
        }

        // sample 테스트 내용 지우고 지워졌는지 확인
        noteRepository.deleteById(sample.getNum());

        result = noteRepository.getWithWriter(sample.getNum());
        assert(!result.isPresent());

    }

    @Test
    public void testGetList() {

        // samples 3개 저장
        samples.forEach(sample -> {
            System.out.println(noteRepository.save(sample));
        });

        // samples 3개 불러와서 각각 같은지 확인
        List<Note> result = noteRepository.getList(samples.get(0).getWriter().getEmail());
        System.out.println(result);

        IntStream.rangeClosed(0, 2).forEach(i -> {
            compareNote(result.get(i), samples.get(i));
        });

        // samples 3개 삭제
        samples.forEach(noteRepository::delete);

        // samples 3개 불러와서 존재하지 않는지 확인
        assert(noteRepository.getList(samples.get(0).getWriter().getEmail()).isEmpty());

    }


    // 두개의 note 내용 같은지 확인
    private void compareNote(Note note1, Note note2) {
        assert(note1.getNum().equals(note2.getNum()));
        assert(note1.getContent().equals(note2.getContent()));
        assert(note1.getTitle().equals(note2.getTitle()));
    }

}
