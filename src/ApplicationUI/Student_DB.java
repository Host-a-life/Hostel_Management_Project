package ApplicationUI;

import java.sql.*;

public class Student_DB
{
    public Connection con;

    public Student_DB()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_management", "root", "Oneplus666");
        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }

    }

    public void write(String name,String roll_num)
    {
        try
        {
            String query = "INSERT INTO students (name ,roll_no) VALUES (?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, roll_num);
            int rows = stmt.executeUpdate();
            if (rows > 0)
            {
                System.out.println("Student was added...");
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public Student read()
    {
        Student student = new Student();
        Statement stm;
        try
        {

            stm = con.createStatement();
            String query = "Select * from students";
            ResultSet rs = stm.executeQuery(query);
            if (rs.next())
            {
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return student;
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
