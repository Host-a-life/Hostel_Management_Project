package ApplicationUI;

public class Student
{
    private String name;
    private String roll_num;
    private  int id;

    Student_DB studentDb = new Student_DB();
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

    public void register_student(String n,String r)
    {
        this.name= n;
        this.roll_num=r;
        studentDb.write(name,roll_num);
    }

}
