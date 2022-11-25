package ApplicationUI;

import java.sql.Struct;

public class Hostel
{
    Student student = new Student();
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
    public void register_student(String n,String r)
    {
        student.register_student(n,r);
    }


}
