import java.text.ParseException;
public interface HotelServicesList {
    public void addHotel();
    public String getCheckInDate();
    public String getCheckInDay(String Date) throws ParseException;
    public String getCheckOutDate();
    public String getCheckOutDay(String Date) throws ParseException;
    public int getStayDays(String checkInDate, String checkOutDate);
    public void findCheapestHotel();
    public void displayAllHotels();
}
