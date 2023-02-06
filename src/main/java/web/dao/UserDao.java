package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> showAllUsers();

    User show(int id);

    void save(User user);

    void update(int id, User upUser);

    void delete(int id);
}
