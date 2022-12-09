package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    private final static UserService userService = new UserServiceImpl();


    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        userService.createUsersTable();

        userService.saveUser("Ivan", "Ivanov", (byte) 25);
        userService.saveUser("Olya", "Orlova", (byte) 30);
        userService.saveUser("Stepan", "Stepanov", (byte) 35);
        userService.saveUser("Aleksey", "Petrov", (byte) 20);

        List<User> userList = userService.getAllUsers();
        userList.stream().forEach(e -> System.out.println(e.toString()));

        userService.cleanUsersTable();
        userService.dropUsersTable();


    }

}

