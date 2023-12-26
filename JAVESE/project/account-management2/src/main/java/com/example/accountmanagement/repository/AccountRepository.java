package com.example.accountmanagement.repository;

import com.example.accountmanagement.dto.BaseResponseDto;
import com.example.accountmanagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    // cú pháp viết method trong spring data jpa
    Optional<Account> findById(Long id);

//    @Query("select u from account u where account.username = :username") //  hql thay cho viec auto generate
    @Query(nativeQuery = true, value = "select * from account where username = :username") // native sql
    Optional<Account> findByUsername(@PathParam("username") String username); // => auto gen sql


}
