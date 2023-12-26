package ls10.lab.dao;

import ls10.lab.model.Customer;

import java.util.List;

public interface Dao<T> {
    List<T> findAll();

    int insert(T data);
}
