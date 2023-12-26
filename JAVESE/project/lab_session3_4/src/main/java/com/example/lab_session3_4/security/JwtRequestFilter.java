package com.example.lab_session3_4.security;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;

    private UsernamePasswordAuthenticationToken getAuthentication(Claims claims) {
        String username = claims.getSubject();

        if (StringUtils.hasText(username)) {
            UserDetails user = userDetailsService.loadUserByUsername(username);
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        }
        return null;
    }
    private static final String AUTHORIZATION_HEADER = "Authorization";
    public static String getTokenFromRequest() {
        String token = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest()
                .getHeader(AUTHORIZATION_HEADER);

        if (token != null && token.startsWith("Bearer")) {
            return token.substring(7);
            //return token.split(" ")[1].trim();
        }

        if (token != null ) {
            return token.trim();
        }



        return "";
    }
    private static String getTokenFromRequest(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return null;
        String accessToken = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("jwt_token")) {
                accessToken = cookie.getValue();
            }
        }

        if (StringUtils.hasText(accessToken)) {
            return accessToken;
        }

        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {

            String jwt = getTokenFromRequest();
            if (!StringUtils.hasText(jwt)) {
                filterChain.doFilter(request, response);
                return;
            }

            if (!jwtTokenUtil.validateToken(jwt)) {
                filterChain.doFilter(request, response);
                return;
            }

            Claims claims = jwtTokenUtil.getClaimsFromToken(jwt);
            if (claims == null) {
                filterChain.doFilter(request, response);
                return;
            }

            UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(claims);
            if (authenticationToken == null) {
                filterChain.doFilter(request, response);
                return;
            }

            // Application context: noi luu tru cac doi tuong khoi tao tu class dc danh dau Bean
            // SecurityContextHolder: noi luu tru cac doi tuong auth
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            log.error("failed on set user authentication" + e);
        }
    }
}
