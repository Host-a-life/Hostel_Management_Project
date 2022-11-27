package ApplicationUI;

public class Mess
{
    Mess_DB mess_db = new Mess_DB();
    private int item_id;
    private String item_name;
    private int item_price;

    private static Mess instance = null;

    private Mess()
    {

    }
    public static Mess getInstance()
    {

        if (instance == null)
        {
            instance = new Mess();
        }
        return instance;
    }
    public void add_item(String name,int price)
    {
        mess_db.add_item(name,price);
    }
    public boolean check_item(String name)
    {
        return mess_db.check_item(name);
    }
    public boolean check_item_id(int id)
    {
        return mess_db.check_item_id(id);
    }
    public void update_item(int id,int price)
    {
        mess_db.update(id,price);
    }
    public void remove_item(int id)
    {
        mess_db.remove_item(id);
    }
}