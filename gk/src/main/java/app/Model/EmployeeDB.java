package app.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.Entity.ExperienceEmployee;
import app.Entity.InternEmployee;
import app.Entity.FresherEmployee;
public class EmployeeDB {


    public static EmployeeDB EmployeeN(){
        return new EmployeeDB();
    }


    public void InsertExperienceEmployee(String id, String fullName, String birthDay, String phone, String email, String employeeType, int expInYear, String proSkill) throws SQLException {
        String querry = "insert into experience (ID,NAME,BDAY,PHONE,EMAIL,TYPE,EXP,SKILL) values (?,?,?,?,?,?,?,?) " ;
        Connection con = connection.connectionDB();
        PreparedStatement ps = con.prepareStatement(querry);
        ps.setNString(1, id);
        ps.setNString(2, fullName);
        ps.setNString(3, birthDay);
        ps.setNString(4, phone);
        ps.setNString(5, email);
        ps.setNString(6, employeeType);
        ps.setInt(7, expInYear);
        ps.setNString(8, proSkill);
        ps.executeUpdate();
        connection.CloseConnect(con);
    }


    public List<ExperienceEmployee> GetExperienceEmployee() throws SQLException{
        List<ExperienceEmployee> lstData = new ArrayList<>();
        String querry = "select * from experience " ;
        Connection con = connection.connectionDB();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(querry);
        while (rs.next()) {
            String id = rs.getString("ID");
            String name = rs.getNString("NAME");
            String bd = rs.getNString("BDAY");
            String sdt = rs.getString("PHONE");
            String mail = rs.getString("EMAIL");
            String type = rs.getNString("TYPE");
            int exp = rs.getInt("EXP");
            String skill = rs.getString("SKILL");
            ExperienceEmployee ex = new ExperienceEmployee(id,name,bd,sdt,mail,type,exp,skill);
            lstData.add(ex);
        }
        connection.CloseConnect(con);
        return lstData;
    }
    public void InsertFresherEmployee(String id, String fullName, String birthDay, String phone, String email, String employeeType, String graduationDate, String graduationRank, String education) throws SQLException {
        String querry = "insert into fresher (ID,NAME,BDAY,PHONE,EMAIL,TYPE,GDATE,GRANK,EDU) values (?,?,?,?,?,?,?,?,?) " ;
        Connection con = connection.connectionDB();
        PreparedStatement ps = con.prepareStatement(querry);
        ps.setNString(1, id);
        ps.setNString(2, fullName);
        ps.setNString(3, birthDay);
        ps.setNString(4, phone);
        ps.setNString(5, email);
        ps.setNString(6, employeeType);
        ps.setNString(7, graduationDate);
        ps.setNString(8, graduationRank);
        ps.setNString(9, education);
        ps.executeUpdate();
        connection.CloseConnect(con);
    }


    public List<FresherEmployee> GetFresherEmployee() throws SQLException{
        List<FresherEmployee> lstData = new ArrayList<>();
        String querry = "select * from fresher " ;
        Connection con = connection.connectionDB();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(querry);
        while (rs.next()) {
            String id = rs.getString("ID");
            String name = rs.getNString("NAME");
            String bd = rs.getNString("BDAY");
            String sdt = rs.getString("PHONE");
            String mail = rs.getString("EMAIL");
            String type = rs.getNString("TYPE");
            String gdate = rs.getNString("GDATE");
            String grank = rs.getString("GRANK");
            String edu = rs.getString("EDU");
            FresherEmployee fe = new FresherEmployee(id,name,bd,sdt,mail,type,gdate,grank,edu);
            lstData.add(fe);
        }
        connection.CloseConnect(con);
        return lstData;
    }



    public void InsertInternEmployee(String id, String fullName, String birthDay, String phone, String email, String employeeType, String majors, String semester, String universityName) throws SQLException {
        String querry = "insert into intern (ID,NAME,BDAY,PHONE,EMAIL,TYPE,MAJORS,SEM,UNINAME) values (?,?,?,?,?,?,?,?,?) " ;
        Connection con = connection.connectionDB();
        PreparedStatement ps = con.prepareStatement(querry);
        ps.setNString(1, id);
        ps.setNString(2, fullName);
        ps.setNString(3, birthDay);
        ps.setNString(4, phone);
        ps.setNString(5, email);
        ps.setNString(6, employeeType);
        ps.setNString(7, majors);
        ps.setNString(8, semester);
        ps.setNString(9, universityName);
        ps.executeUpdate();
        connection.CloseConnect(con);
    }


    public List<InternEmployee> GetInternEmployee() throws SQLException{
        List<InternEmployee> lstData = new ArrayList<>();
        String querry = "select * from intern " ;
        Connection con = connection.connectionDB();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(querry);
        while (rs.next()) {
            String id = rs.getString("ID");
            String name = rs.getNString("NAME");
            String bd = rs.getNString("BDAY");
            String sdt = rs.getString("PHONE");
            String mail = rs.getString("EMAIL");
            String type = rs.getNString("TYPE");
            String ma = rs.getNString("MAJORS");
            String sem = rs.getString("SEM");
            String uni = rs.getString("UNINAME");
            InternEmployee ie = new InternEmployee(id,name,bd,sdt,mail,type,ma,sem,uni);
            lstData.add(ie);
        }
        connection.CloseConnect(con);
        return lstData;
    }

    


}
