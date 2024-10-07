package IGeneric;

import Entity.Customer;

import java.util.List;

public interface IGeneralService<T> {
    // Cập nhật thông tin một Object
    void update(T t);

    // Sắp xếp danh sách các Object
    List<T> sortByName();

    // Tìm kiếm theo id
    T getById(int id);

    // Tìm kiếm theo tên
    List<T> getByName(String name);
}