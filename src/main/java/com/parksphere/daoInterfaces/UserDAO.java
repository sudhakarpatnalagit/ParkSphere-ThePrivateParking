package com.parksphere.daoInterfaces;

 import java.util.List;

import com.parksphere.model.User;
 

public interface UserDAO {

    boolean registerUser(User user);

    User login(String email, String password);

    User getUserById(int userId);

    List<User> getAllUsers();

    boolean updateUser(User user);

    boolean deleteUser(int userId);
    
    boolean blockUser(int userId);

    boolean activateUser(int userId);
}