package dao.inter;

import java.util.List;

public interface UserDaoInter {
    public List<User> getall();
    public User getById(int id);
    public boolean updateUser(User u);
    public boolean removeUser(int id);

}
