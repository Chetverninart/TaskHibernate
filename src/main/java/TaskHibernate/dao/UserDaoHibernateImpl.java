package TaskHibernate.dao;

import TaskHibernate.model.User;
import TaskHibernate.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createSQLQuery("drop table if exists users").executeUpdate();
        session.createSQLQuery("create table users (id bigint not null auto_increment, " +
                "name varchar(255), lastName varchar(255), age tinyint, primary key (id))").executeUpdate();
        tx1.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createSQLQuery("drop table if exists users").executeUpdate();
        tx1.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);

        Session session = Util.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(user);
        tx1.commit();
        session.close();
        System.out.printf("User с именем – %s добавлен в базу данных\n", name);
    }

    @Override
    public void removeUserById(long id) {
        User user = new User();
        user.setId(id);

        Session session = Util.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers(){
        Session session = Util.getSessionFactory().openSession();
        try{
            return session.createCriteria(User.class).list();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createSQLQuery("TRUNCATE TABLE users").executeUpdate();
        tx1.commit();
        session.close();
    }
}
