package ApplicationUI;

public class Hostel {
    Student s = new Student();
    public void mainfunction()
    {
        System.out.println("hello");
    }
    public boolean authentication(String id, String pw)
    {
        return s.authentication(id,pw);
    }
    public boolean addtofees(String item)
    {
        return s.addtofees(item);
    }
    Integer calculatefees()
    {
        Integer fees = s.calculatefees();
        return fees;
    }
}