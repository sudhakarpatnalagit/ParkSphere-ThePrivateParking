package com.parksphere.daoInterfaces;

import com.parksphere.model.Admin;

public interface AdminDAO {

    Admin login(String username, String password);

    Admin getAdminById(int adminId);

    boolean updateAdmin(Admin admin);

    boolean changePassword(int adminId, String password);
}
