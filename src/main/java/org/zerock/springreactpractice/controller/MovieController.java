package org.zerock.springreactpractice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.springreactpractice.dto.MovieDTO;
import org.zerock.springreactpractice.dto.PageRequestDTO;
import org.zerock.springreactpractice.dto.PageResultDTO;
import org.zerock.springreactpractice.service.MovieService;

@RestController
@RequestMapping("/api/movie")
@Log4j2
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDTO<MovieDTO, Object[]>> getList(PageRequestDTO pageRequestDTO) {

        log.info("pageRequestDTO : " + pageRequestDTO);

        return new ResponseEntity<>(movieService.getList(pageRequestDTO), HttpStatus.OK);

    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> register(@RequestBody MovieDTO movieDTO) {

        log.info("movieDTO : " + movieDTO);

        Long mno = movieService.register(movieDTO);

        return new ResponseEntity<>(mno, HttpStatus.OK);

    }

    @GetMapping(value = "/{mno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDTO> get(@PathVariable("mno") Long mno) {

        log.info("mno: " + mno);

        return new ResponseEntity<>(movieService.get(mno), HttpStatus.OK);

    }



}
