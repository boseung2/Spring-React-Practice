package com.springreactpractice.security.filter;

import lombok.extern.log4j.Log4j2;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import com.springreactpractice.security.dto.AuthMemberDTO;
import com.springreactpractice.util.JWTUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@Log4j2
public class ApiLoginFilter extends AbstractAuthenticationProcessingFilter {

    private JWTUtil jwtUtil;

    public ApiLoginFilter(String defaultFilterProcessesUrl, JWTUtil jwtUtil) {
        super(defaultFilterProcessesUrl);
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        log.info("--------------ApiLoginFilter-------------");
        log.info("attemptAuthentication");

        String requestData = request.getReader().lines().collect(Collectors.joining());

        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse( requestData );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObj = (JSONObject) obj;

        String email = (String) jsonObj.get("email");
        String pw = (String) jsonObj.get("pw");

        log.info("data : " + requestData);

        //String email = request.getParameter("email");
        //String pw = request.getParameter("pw");

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(email, pw);

        return getAuthenticationManager().authenticate(authToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        log.info("-------------APILoginFilter--------------");
        log.info("successfulAuthentication : " + authResult);
        log.info(authResult.getPrincipal());

        //email address
        String email = ((AuthMemberDTO)authResult.getPrincipal()).getUsername();

        String token = null;

        try {
            token = jwtUtil.generateToken(email);

            response.setContentType("text/plain");
            response.getOutputStream().write(token.getBytes());

            log.info(token);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
