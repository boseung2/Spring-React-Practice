package com.springreactpractice.security.service;

import com.springreactpractice.entity.Member;
import com.springreactpractice.security.dto.AuthMemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import com.springreactpractice.entity.MemberRole;
import com.springreactpractice.repository.MemberRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class ClubOAuth2UserDetailService extends DefaultOAuth2UserService {

    private final MemberRepository repository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("-----------");
        log.info("userRequest : " + userRequest); //OAuth2UserRequest객체

        String clientName = userRequest.getClientRegistration().getClientName();

        log.info("clientName : " + clientName); // Google로 출력
        log.info(userRequest.getAdditionalParameters());

        OAuth2User oAuth2User = super.loadUser(userRequest);

        log.info("===========");
        oAuth2User.getAttributes().forEach((k, v) -> {
            log.info(k + ":" + v); // sub, picture, email, email_verified, EMAIL 등이 출력
        });

        String email = null;

        if(clientName.equals("Google")) {
            email = oAuth2User.getAttribute("email");
        }

        log.info("EMAIL : " + email);

        //ClubMember member = saveSocialMember(email);

        //return oAuth2User;

        Member member = saveSocialMember(email);

        AuthMemberDTO clubAuthMember = new AuthMemberDTO(
                member.getEmail(),
                member.getPassword(),
                true,
                member.getRoleSet().stream().map(
                        role -> new SimpleGrantedAuthority("ROLE_" + role.name())
                ).collect(Collectors.toList()),
                oAuth2User.getAttributes()
        );
        clubAuthMember.setName(member.getName());

        return clubAuthMember;

    }

    private Member saveSocialMember(String email) {

        Optional<Member> result = repository.findByEmail(email, true);

        if(result.isPresent()) {
            return result.get();
        }

        Member member = Member.builder().email(email)
                .name(email)
                .password(passwordEncoder.encode("1111"))
                .fromSocial(true)
                .build();

        member.addMemberRole(MemberRole.USER);

        repository.save(member);

        return member;

    }

}
