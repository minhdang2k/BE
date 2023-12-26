package com.example.accountmanagement.repository;

import com.example.accountmanagement.mapper.RowMapper;

import java.util.List;

public interface Dao <T>{
    List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
    Boolean insert(String sql, Object... parameters);
    Boolean update(String sql, Object... parameters);
    Boolean delete(String sql, Object... parameters);

}
