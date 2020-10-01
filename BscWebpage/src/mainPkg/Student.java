package mainPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dbConn.*;

public class Student extends User{

    public Student(){
        super();
    }
    public Student(String am, String password){
        super(am,password);
    }



    public static ResultSet GetStudentsWork(String id){
        ResultSet resultSet;
        con = ConnectionProvider.getCon();
        try{
            stmt = con.prepareStatement("select supervisors.fullname,supervisors.email,bsc_thesis,start_date,prog_languages,tools,progress,meeting,grade from students inner join supervisors on students.supervisor = supervisors.id where students.am = ?");
            stmt.setString(1,id);
            resultSet = stmt.executeQuery();
            con.close();
            return resultSet;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}