package com.example.accountmanagement.security;

import com.example.accountmanagement.entity.Account;
import com.example.accountmanagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User get username " + username + " does not exist!"));

        return new CustomUserDetails(user);
    }
}
