package ApplicationUI;

public class Seat
{
    private int seat_no;
    private String status;

    public Seat()
    {
        this.seat_no = 0;
        this.status = "0";
    }

    public Seat(int seat_no, String status)
    {
        this.seat_no = seat_no;
        this.status = status;
    }

    public int getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(int seat_no) {
        this.seat_no = seat_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
