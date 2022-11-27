package ApplicationUI;

import java.sql.*;
import java.util.Hashtable;
import java.util.List;

public class Mess {

    private static Mess instance = null;
    private Mess()
    {

    }
    public static synchronized Mess getInstance()
    {
        if(instance == null)
        {
            instance = new Mess();
        }
        return instance;
    }

    private Hashtable<String, Integer> itemNprice = new Hashtable<String, Integer>();

    public Hashtable<String, Integer> itemNpricetablereturner()
    {
        String itemname;
        int itemprice;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hmsdb","root","1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from mess");
            while(rs.next())
            {
                itemNprice.put(rs.getString("item_name"),rs.getInt("item_price"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return itemNprice;
    }
}
