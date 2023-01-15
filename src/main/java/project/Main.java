package project;

import project.dao.UserDao;
import project.dao.UserDaoJDBCImpl;
import project.model.User;
import project.util.Util;

import java.sql.SQLException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        Util util = new Util();
        util.getConnection();
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();

        userDao.saveUser("Ivan", "Ivanov", (byte) 25);
        userDao.saveUser("Olya", "Orlova", (byte) 30);
        userDao.saveUser("Stepan", "Stepanov", (byte) 35);
        userDao.saveUser("Aleksey", "Petrov", (byte) 20);

        List<User> userList = userDao.getAllUsers();
        userList.stream().forEach(e -> System.out.println(e.toString()));

        userDao.cleanUsersTable();
        userDao.dropUsersTable();


    }

}

