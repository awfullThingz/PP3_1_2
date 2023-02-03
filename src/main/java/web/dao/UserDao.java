package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> showUsers();

    User getUser(int id);

    void save(User user);

    void update(int id, User upUser);

    void delete(int id);
}
