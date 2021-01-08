package TaskHibernate.service;

import TaskHibernate.dao.*;
import TaskHibernate.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao JDBC;
    private final UserDao Hibernate;

    public UserServiceImpl() {
        JDBC = new UserDaoJDBCImpl();
        Hibernate = new UserDaoHibernateImpl();
    }

    public void createUsersTable() {
        Hibernate.createUsersTable();
    }

    public void dropUsersTable() {
        Hibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        Hibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        Hibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return Hibernate.getAllUsers();
    }

    public void cleanUsersTable() {
        Hibernate.cleanUsersTable();
    }

}
