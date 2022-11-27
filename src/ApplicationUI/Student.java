package ApplicationUI;

public class Student {

    private static Student instance = null;
    private Student()
    {

    }
    public static synchronized Student getInstance()
    {
        if(instance == null)
        {
            instance = new Student();
        }
        return instance;
    }
    //Authenticate a = new Authenticate();
    //Fees f = new Fees();
    public boolean authentication(String id, String pw)
    {
        return Authenticate.getInstance().authentication(id,pw);
    }
    public boolean addtofees(String item)
    {
        return Fees.getInstance().addtofees(item);
    }
    Integer calculatefees()
    {
        Integer fees = Fees.getInstance().calculatefees();
        return fees;
    }
    Boolean payfees(Integer amount,String accno)
    {
        boolean feestatus;
        feestatus = Fees.getInstance().payfees(amount,accno);
        return feestatus;
    }
}
