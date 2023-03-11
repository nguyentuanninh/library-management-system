/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbConnect;

import DAO.BookDAO;
import DAO.UserDAO;
import entity.Book;
import entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author MSII
 */
public class TestConnection {
    public static void main(String[] args) throws Exception {
        UserDAO userDao = new UserDAO();

        User newUser = new User();
newUser.setUsername("JohnDoe");
newUser.setPassword("password");
newUser.setRole(false);
newUser.setName("John Doeeeeee");
newUser.setAvt("img/avt/john.jpg");
newUser.setSex(true);
newUser.setDatebirth("2023-03-11");
newUser.setPhone("1234567890");
newUser.setGmail("johndoe@gmail.com");
//userDao.deleteUser("JohnDoe");

    ArrayList<User> list= userDao.getAllUser();
    for(User user: list){
        System.out.println(user.getName());
    }

    }
}
