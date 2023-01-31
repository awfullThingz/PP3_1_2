package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> showUsers();
    public User getUser(int id);

    public void save(User user);

    public void update(int id, User upUser);

    public void delete (int id);
}
