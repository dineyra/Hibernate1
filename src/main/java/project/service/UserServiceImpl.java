package project.service;

import project.dao.UserDao;
import project.dao.UserDaoHibernateImpl;
import project.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoHibernateImpl();

    public void createUsersTable() throws SQLException {
        userDao.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
      return userDao.getAllUsers();
    }


    public void cleanUsersTable() throws SQLException {
        userDao.cleanUsersTable();
    }

    @Override
    public void saveUser(User user) {
        try {
            userDao.saveUser(user.getName(), user.getLastName(), user.getAge());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
