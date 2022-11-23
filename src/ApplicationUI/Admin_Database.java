package ApplicationUI;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Scanner;

public class Admin_Database
{
    public Connection con;

    public Admin_Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_management", "root", "Oneplus666");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void write()
    {
        try
        {
            String query = "INSERT INTO admin (password, username) VALUES (?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, "123");
            stmt.setString(2, "Usman");
            int rows = stmt.executeUpdate();
            if (rows > 0)
            {
                System.out.println("Admin was added...");
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public Admin read()
    {
        Admin admin = new Admin();
        Statement stm;
        try
        {

            stm = con.createStatement();
            String query = "Select * from admin where password = '123' AND username = 'Usman'";
            ResultSet rs = stm.executeQuery(query);
            if (rs.next())
            {
               // System.out.println("________________________");
               // System.out.println("Admin password = " + rs.getInt(1) + "\nAdmin username = " + rs.getString(2));
                //System.out.println("________________________");
                admin.setPass(rs.getString(2));
                admin.setName(rs.getString(1));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return admin;
    }
    public void close_connection()
    {
        try
        {
            con.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
