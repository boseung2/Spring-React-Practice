package org.zerock.springreactpractice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.springreactpractice.dto.NoteDTO;
import org.zerock.springreactpractice.service.NoteService;

import javax.print.attribute.standard.Media;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/api/note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteservice;

    @PostMapping("")
    public ResponseEntity<Long> register(@RequestBody NoteDTO noteDTO) {

        log.info("-----register------");
        log.info(noteDTO);

        Long num = noteservice.register(noteDTO);

        return new ResponseEntity<>(num, HttpStatus.OK);

    }

    @GetMapping(value = "/{num}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NoteDTO> read(@PathVariable("num") Long num) {

        log.info("---------read-------------");
        log.info(num);
        return new ResponseEntity<>(noteservice.get(num), HttpStatus.OK);

    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NoteDTO>> getList(String email) {

        log.info("-----getList-----");
        log.info(email);

        return new ResponseEntity<>(noteservice.getAllWithWriter(email), HttpStatus.OK);

    }

    @DeleteMapping(value = "/{num}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> remove(@PathVariable("num") Long num) {

        log.info("-----------remove------------");
        log.info(num);

        noteservice.remove(num);

        return new ResponseEntity<>("removed", HttpStatus.OK);

    }

    @PutMapping(value = "/{num}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> modify(@RequestBody NoteDTO noteDTO) {

        log.info("-------modify--------------");
        log.info(noteDTO);

        noteservice.modify(noteDTO);

        return new ResponseEntity<>("modified", HttpStatus.OK);

    }

}
