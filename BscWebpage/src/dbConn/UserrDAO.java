package dbConn;
import mainPkg.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserrDAO {
    static Connection con;
    static PreparedStatement stmt;

    public static ResultSet GetAllStudentInfo(String id){
        ResultSet resultSet;
        con = ConnectionProvider.getCon();
        try{
            stmt = con.prepareStatement("select am,students.fullname,students.email,orientation,bsc_thesis,start_date,prog_languages,tools,progress from students inner join supervisors on students.supervisor = supervisors.id where supervisor= ?");
            stmt.setString(1,id);
            resultSet = stmt.executeQuery();
            con.close();
            return resultSet;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet GetStudentsWork(String id){
        ResultSet resultSet;
        con = ConnectionProvider.getCon();
        try{
            stmt = con.prepareStatement("select supervisors.fullname,supervisors.email,bsc_thesis,start_date,prog_languages,tools,progress,grade from students inner join supervisors on students.supervisor = supervisors.id where students.am = ?");
            stmt.setString(1,id);
            resultSet = stmt.executeQuery();
            con.close();
            return resultSet;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet GetSuperReport(String am){
        ResultSet resultSet;
        con = ConnectionProvider.getCon();
        try{
            stmt = con.prepareStatement("select students.fullname,students.email,orientation,bsc_thesis,start_date,prog_languages,tools,progress,grade from students inner join supervisors on students.supervisor = supervisors.id where students.am = ?");
            stmt.setString(1,am);
            resultSet = stmt.executeQuery();
            con.close();
            return resultSet;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
