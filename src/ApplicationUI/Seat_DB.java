package ApplicationUI;

import java.sql.*;

public class Seat_DB
{
    public Connection con;

    public Seat_DB()
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

    public void write(int seat_no,String status)
    {
        try
        {
            String query = "INSERT INTO seat (seat_no ,status) VALUES (?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, seat_no);
            stmt.setString(2, status);
            int rows = stmt.executeUpdate();
            if (rows > 0)
            {
                System.out.println("Seat was added...");
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public Seat read()
    {
        Seat seat = new Seat();
        Statement stm;
        try
        {

            stm = con.createStatement();
            String query = "Select * from seat";
            ResultSet rs = stm.executeQuery(query);
            if (rs.next())
            {
                seat.setSeat_no(rs.getInt(1));
                seat.setStatus(rs.getString(2));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return seat;
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
