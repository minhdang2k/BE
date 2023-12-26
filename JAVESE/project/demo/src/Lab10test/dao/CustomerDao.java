package Lab10test.dao;

import Lab10test.model.Customer;

import java.util.List;

public interface CustomerDao<T> {
    List<T> findAll();
    int insert(T data);
}
