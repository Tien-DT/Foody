/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.User;
import MyLib.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class UserDAO implements Serializable {

    public ArrayList<User> getUser() {
        ArrayList<User> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select * from dbo.[User]";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int userID = rs.getInt("UserID");
                    String fullName = rs.getNString("FullName");
                    String email = rs.getString("Email");
                    boolean role = rs.getBoolean("Role");
                    String password = rs.getString("Password");

                    boolean userStatus = rs.getBoolean("UserStatus");

                    User user = new User(userID, fullName, email, role, password, userStatus);
                    list.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public String getUserLogin(String email, String passwordDecoded) {
        String Email = null;
        Connection cn = null;
        try {

            cn = DBUtil.makeConnection();
            if (cn != null) {

                String sql = "select Email, Password from dbo.[User]\n"
                        + "where Email=? and Password=? COLLATE Latin1_General_CS_AS and UserStatus='1'";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, passwordDecoded);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    Email = rs.getString("Email");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Email;
    }

    public int getUserID(String email) {
        int userID = 0;
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select UserID from dbo.[User] where Email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    userID = rs.getInt("UserID");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userID;
    }

    public boolean deleteUserByID(int userID) {
        boolean check = false;
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "DELETE dbo.[User]\n"
                        + "WHERE UserID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    public String getFullName(String email) {
        String fullName = null;
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select FullName from dbo.[User] where Email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    fullName = rs.getNString("FullName");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fullName;
    }
    
    public int isStaff(int userID) {
        int userRole = 0;
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select Role from dbo.[User] where UserID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    userRole = rs.getInt("Role");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userRole;
    }

    public String getUserByEmail(String email) {
        String Email = null;
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select Email from dbo.[User]\n"
                        + "where Email=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    Email = rs.getString("Email");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Email;
    }

    public String registerUser(String fullName, String email, String passwordEncoded) {
        Connection cn = null;
        String result = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                // Disable auto-commit mode
                cn.setAutoCommit(false);

                String sql = "INSERT INTO [User] (FullName, Email, Password, UserStatus, Role) VALUES (?, ?, ?, '1', '0')";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setNString(1, fullName);
                pst.setString(2, email);
                pst.setString(3, passwordEncoded);

                // Execute update and get affected rows
                int affectedRows = pst.executeUpdate();

                if (affectedRows > 0) {
                    // Commit the transaction if insert is successful
                    cn.commit();
                    result = "Insert successful";
                } else {
                    // Rollback the transaction if insert failed
                    cn.rollback();
                    result = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (cn != null) {
                    cn.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            result = "An error occurred: " + e.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean disableUser(int userIDToDelete) {
        Connection cn = null;
        boolean check = false;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "UPDATE dbo.[User]\n"
                        + "SET UserStatus ='0' \n"
                        + "WHERE UserID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1,userIDToDelete);
                int affectedRows = pst.executeUpdate();
                if (affectedRows > 0) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }
    
    public boolean enableUser(int userIDToEnable) {
        Connection cn = null;
        boolean check = false;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "UPDATE dbo.[User]\n"
                        + "SET UserStatus ='1' \n"
                        + "WHERE UserID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1,userIDToEnable);
                int affectedRows = pst.executeUpdate();
                if (affectedRows > 0) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }
    
    public boolean setStaff(int userIDSet) {
        Connection cn = null;
        boolean check = false;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "UPDATE dbo.[User]\n"
                        + "SET Role ='1' \n"
                        + "WHERE UserID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1,userIDSet);
                int affectedRows = pst.executeUpdate();
                if (affectedRows > 0) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }
}
