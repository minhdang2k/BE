package DangTieuMinh_JavaSE_Final_Test.Ex2.dao;

import java.util.List;

public interface Dao<T> {
    List<T> findAll();
    int insert(T data);
}
