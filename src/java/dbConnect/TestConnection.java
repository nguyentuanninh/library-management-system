/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbConnect;

import DAO.BookDAO;
import DAO.BorrowerDAO;
import DAO.UserDAO;
import entity.Book;
import entity.Borrower;
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
//userDao.insertUser(newUser);

//User user1= userDao.findUserByUsername("user1");
//user1.setPassword("1232");
//userDao.updateUser(user1);
//
//    ArrayList<User> list= userDao.getAllUser();
//    for(User user: list){
//        System.out.println(user.getName()+" "+ user.getAvt()+" "+ user.getPassword());
//    }
        BorrowerDAO bDAO = new BorrowerDAO();
        ArrayList<Borrower> list = bDAO.getBorrowerByStatusAndUserId(null, null);
        for (Borrower b : list) {
            System.out.println(b.getBookid());
        }

    }
}
