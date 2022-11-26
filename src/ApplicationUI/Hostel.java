package ApplicationUI;

public class Hostel
{
    Student student = new Student();
    Room room = new Room();
    Mess mess = new Mess();
    private String name;
    private String location;

    Hostel()
    {
        this.name = "\0";
        this.location = "\0";
    }
    Hostel(String n,String loc)
    {
        this.name = n;
        this.location = loc;
    }
    public void register_student(String n, String r, int room, int seat)
    {
        student.register_student(n,r,room,seat);
    }
    public int[] check_room_availability(int id)
    {
        return room.check_room_availability(id);
    }
    public boolean check_room(String id)
    {
        return room.check_room(id);
    }
    public void add_item(String name,int price)
    {
        mess.add_item(name,price);
    }
    public boolean check_item(String name)
    {
        return mess.check_item(name);
    }
    public boolean check_item_id(int id)
    {
        return mess.check_item_id(id);
    }
    public void update_item(int id,int price)
    {
        mess.update_item(id,price);
    }
    public void remove_item(int id)
    {
        mess.remove_item(id);
    }

}
