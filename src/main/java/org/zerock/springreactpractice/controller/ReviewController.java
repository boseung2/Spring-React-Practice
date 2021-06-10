package org.zerock.springreactpractice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.springreactpractice.dto.ReviewDTO;
import org.zerock.springreactpractice.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@Log4j2
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{mno}")
    public ResponseEntity<List<ReviewDTO>> getList(@PathVariable("mno") Long mno) {

        log.info("MNO : " + mno);
        List<ReviewDTO> reviewDTOList = reviewService.getList(mno);

        return new ResponseEntity<>(reviewDTOList, HttpStatus.OK);

    }

    @PostMapping("/{mno}")
    public ResponseEntity<Long> register(@RequestBody ReviewDTO reviewDTO) {

        log.info("reviewDTO : " + reviewDTO);

        Long reviewnum = reviewService.register(reviewDTO);

        return new ResponseEntity<>(reviewnum, HttpStatus.OK);

    }

    @PutMapping("/{reviewnum}")
    public ResponseEntity<Long> modify(@PathVariable Long reviewnum, @RequestBody ReviewDTO reviewDTO) {

        log.info("reviewDTO : " + reviewDTO);

        reviewService.modify(reviewDTO);

        return new ResponseEntity<>(reviewnum, HttpStatus.OK);

    }

    @DeleteMapping("/{reviewnum}")
    public ResponseEntity<Long> removeReview(@PathVariable Long reviewnum) {

        log.info("reviewnum : " + reviewnum);

        reviewService.remove(reviewnum);

        return new ResponseEntity<>(reviewnum, HttpStatus.OK);
    }

}
