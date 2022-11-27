package ApplicationUI;

public class Hostel {
    //Student s = new Student();
    private static Hostel instance = null;
    private Hostel()
    {

    }
    public static synchronized Hostel getInstance()
    {
        if(instance == null)
        {
            instance = new Hostel();
        }
        return instance;
    }
    public void mainfunction()
    {
        System.out.println("hello");
    }
    public boolean authentication(String id, String pw)
    {
        return Student.getInstance().authentication(id,pw);
    }
    public boolean addtofees(String item)
    {
        return Student.getInstance().addtofees(item);
    }
    Integer calculatefees()
    {
        Integer fees = Student.getInstance().calculatefees();
        return fees;
    }
    Boolean payfees(Integer amount,String accno)
    {
        boolean feestatus;
        feestatus = Student.getInstance().payfees(amount,accno);
        return feestatus;
    }
}