package mainPkg;

import dbConn.ConnectionProvider;
import dbConn.MD5;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class Users {
    private String username,password;

    public Users(String u, String p){
        username = u;
        password = p;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login(){
        Connection con;
        PreparedStatement pst;
        ResultSet results = null;
        try{
            con = ConnectionProvider.getCon();
            pst = con.prepareStatement("select hash,salt from users where id = ?");
            pst.setString(1,this.getUsername());
            results = pst.executeQuery();
            
            while(results.next()){
                byte[] userSalt = results.getBytes("salt");
                String userHash = results.getString("hash");
                
                String password = this.getPassword();
                String currentHash = MD5.makeHash(password,userSalt);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
