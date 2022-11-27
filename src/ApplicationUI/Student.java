package ApplicationUI;

public class Student
{
    private String name;
    private String roll_num;
    private  int id;

    Student_DB studentDb = new Student_DB();
    Room_DB room_db = new Room_DB();
    public Student()
    {
        this.name = "0";
        this.roll_num = "0";
        this.id = 0;
    }

    public Student(int id,String name,String roll_num )
    {
        this.name = name;
        this.id = id;
        this.roll_num = roll_num;
    }
    public String getName() {
        return name;
    }

    public String getRoll_num() {
        return roll_num;
    }

    public void setRoll_num(String roll_num) {
        this.roll_num = roll_num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean check_student(String id)
    {
        return studentDb.check_student(id);
    }
    public void Allocate_Room(String id, String room_id, String seat_num)
    {
        studentDb.update(id, room_id, seat_num);
        room_db.update(id,room_id,seat_num);
    }
    public void register_student(String n, String r, int room, int seat)
    {
        this.name= n;
        this.roll_num=r;
        studentDb.write(name,roll_num,room,seat);
    }

}
