package TaskHibernate.service;

import TaskHibernate.dao.*;
import TaskHibernate.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao jdbc;
    private final UserDao hibernate;

    public UserServiceImpl() {
        jdbc = new UserDaoJDBCImpl();
        hibernate = new UserDaoHibernateImpl();
    }

    public void createUsersTable() {
        hibernate.createUsersTable();
    }

    public void dropUsersTable() {
        hibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        hibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        hibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return hibernate.getAllUsers();
    }

    public void cleanUsersTable() {
        hibernate.cleanUsersTable();
    }

}
