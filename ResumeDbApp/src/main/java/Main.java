import dao.inter.User;
import dao.inter.UserDaoImpl;
import dao.inter.UserDaoInter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Main {


    public static void main(String[] args)throws Exception {
        UserDaoInter userDao = new UserDaoImpl();
//        List <User>list= userDao.getall();
//        userDao.removeUser(1);
//        List <User>list1= userDao.getall();
//        System.out.println("List: "+list);
//        System.out.println("List: "+list1);
        User u=userDao.getById(2);
        u.setName("Elvin");
        userDao.updateUser(u);
    }
}
