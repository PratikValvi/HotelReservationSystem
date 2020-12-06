import java.text.ParseException;
import java.util.ArrayList;

public interface HotelServicesList {
    public void addExistingHotels();
    public void addHotel();
    public String getCheckInDate();
    public String getCheckInDay(String Date) throws ParseException;
    public String getCheckOutDate();
    public String getCheckOutDay(String Date) throws ParseException;
    public int getStayDays(String checkInDate, String checkOutDate);
    public ArrayList<String> getListofDays(String checkInDate, String checkOutDate) throws ParseException;
    public void findCheapestHotel() throws ParseException;
    public void displayAllHotels();
}
