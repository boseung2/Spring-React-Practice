package org.zerock.springreactpractice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.springreactpractice.dto.BoardDTO;
import org.zerock.springreactpractice.dto.PageRequestDTO;
import org.zerock.springreactpractice.dto.PageResultDTO;
import org.zerock.springreactpractice.service.BoardService;

@RestController
@RequestMapping("/api/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDTO<BoardDTO, Object[]>> getList(PageRequestDTO pageRequestDTO) {

        log.info("-----getList-----");
        log.info(pageRequestDTO);

        return new ResponseEntity<>(boardService.getList(pageRequestDTO), HttpStatus.OK);

    }

    @PostMapping(value = "")
    public ResponseEntity<Long> register(@RequestBody BoardDTO dto) {

        log.info("-----register-----");
        log.info(dto);

        Long bno = boardService.register(dto);

        return new ResponseEntity<>(bno, HttpStatus.OK);

    }

    @GetMapping(value = "/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BoardDTO> read(@PathVariable("bno") Long bno) {

        log.info("-----read-----");
        log.info(bno);

        return new ResponseEntity<>(boardService.get(bno), HttpStatus.OK);

    }

    @PutMapping(value = "/{bno}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> modify(@RequestBody BoardDTO dto) {

        log.info("-----modify-----");
        log.info(dto);

        boardService.modify(dto);

        return new ResponseEntity<>("modified", HttpStatus.OK);

    }

    @DeleteMapping(value = "/{bno}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> remove(@PathVariable("bno") Long bno) {

        log.info("-----delete-----");
        log.info(bno);

        boardService.removeWithReplies(bno);

        return new ResponseEntity<>("removed", HttpStatus.OK);

    }

}
