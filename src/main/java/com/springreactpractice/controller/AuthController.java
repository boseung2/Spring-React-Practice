package com.springreactpractice.controller;

import com.springreactpractice.entity.Member;
import com.springreactpractice.entity.MemberRole;
import com.springreactpractice.repository.MemberRepository;
import com.springreactpractice.security.dto.AuthMemberDTO;
import com.springreactpractice.security.dto.SignUpRequest;
import exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@Log4j2
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MemberRepository memberRepository;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

        if(memberRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>("email already in use", HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        Member member = Member.builder()
                .email(signUpRequest.getEmail())
                .name(signUpRequest.getName())
                .fromSocial(false)
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .build();

        member.addMemberRole(MemberRole.USER);

        Member result = memberRepository.save(member);

        return new ResponseEntity<>("success", HttpStatus.OK);

    }

}