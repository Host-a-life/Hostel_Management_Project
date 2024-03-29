package ApplicationUI;

import java.sql.*;

public class Room_DB
{
    public Connection con;

    public Room_DB()
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

    public void write(String seat1,String seat2,String seat3)
    {
        try
        {
            String query = "INSERT INTO room (seat1,seat2,seat3) VALUES (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,seat1);
            stmt.setString(2,seat2);
            stmt.setString(3,seat3);
            int rows = stmt.executeUpdate();
            if (rows > 0)
            {
                System.out.println("Room was added...");
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void writing(String name,String r_id,String seat)
    {
        int seat_no = Integer.parseInt(seat);
        try
        {
            String query = "INSERT INTO room (seat"+seat_no+") VALUES (?) where id = "+r_id;
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,name);
            int rows = stmt.executeUpdate();
            if (rows > 0)
            {
                System.out.println("Student is added...");
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public boolean check_room_id(String id)
    {
        Statement stm;
        try
        {

            stm = con.createStatement();
            String query = "Select * from room";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next())
            {
                if (rs.getString("id").equals(id))
                    return true;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }
    public void update(String s_id,String r_id,String seat)
    {
        int seat_no = Integer.parseInt(seat);
        try
        {
            String query = "update room set seat_sid"+seat_no+ " = "+"'"+s_id+"'"+" where id = "+r_id;
            PreparedStatement stmt = con.prepareStatement(query);
            int rows = stmt.executeUpdate();
            if (rows > 0)
            {
                System.out.println("Student is added...");
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public Room read(int i)
    {
        //Room room = new Room();
        Statement stm;
        try
        {

            stm = con.createStatement();
            String query = "Select * from room where id = "+i;
            ResultSet rs = stm.executeQuery(query);
            if (rs.next())
            {
                Room.getInstance().setId(rs.getInt(1));
                Room.getInstance().setSeat1(rs.getString(2));
                Room.getInstance().setSeat2(rs.getString(3));
                Room.getInstance().setSeat3(rs.getString(4));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return Room.getInstance();
    }
    public boolean reading_student_in_seats(String id)
    {
        Statement stm;
        try
        {
            boolean flag = false;
            stm = con.createStatement();
            String query = "Select * from room";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next())
            {
                if (rs.getString("seat_sid1").equals(id) || rs.getString("seat_sid2").equals(id) || rs.getString("seat_sid3").equals(id))
                {
                    return true;
                }
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
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
