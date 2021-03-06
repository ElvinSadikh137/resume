package dao.inter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDaoImpl extends AbstratDAO implements UserDaoInter {
    @Override
    public List<User> getall() {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()){
            Statement stmt = c.createStatement();
            stmt.execute("select * from user");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                result.add(new User(id,name,surname,email,phone));
            }
            //rs.close();
            //stmt.close();
            //c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    @Override
    public boolean updateUser(User u) {
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user set name=?,surname=?,email=?,phone=? where id=?");
            stmt.setString(1,u.getName());
            stmt.setString(2,u.getSurname());
            stmt.setString(3,u.getEmail());
            stmt.setString(4,u.getPhone());
            stmt.setInt(5,u.getId());
            return stmt.execute();
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try(Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id = "+id);
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    @Override
    public User getById(int userId){
        User result = null;
        try (Connection c = connect()){
            Statement stmt = c.createStatement();
            stmt.execute("select * from user where id ="+userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                result= new User(id,name,surname,email,phone);
            }
            //rs.close();
            //stmt.close();
            //c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


}
