import java.util.*;
import java.time.LocalDate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import static java.util.Collections.sort;

public class HotelServicesImplementation implements HotelServicesList {
    ArrayList<Hotel> hotelList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    @Override
    public void addHotel() {
        String hotelName;
        Hotel hotel = new Hotel();
        System.out.println("Enter Name of Hotel: ");
        do {
            hotelName = scan.nextLine();
        } while (hotelName.isEmpty());
        System.out.println("Enter Rating(from 1 to 5) of Hotel: ");
        int hotelRating = scan.nextInt();
        System.out.println("Enter Rate for Regular Customers: ");
        int rateForRegularCustomers = scan.nextInt();
        System.out.println("Enter Rate for Reward Customers: ");
        int rateForRewardCustomers = scan.nextInt();
        hotel.setName(hotelName);
        hotel.setRating(hotelRating);
        hotel.setRateForRegularCustomer(rateForRegularCustomers);
        hotel.setRateForRewardCustomer(rateForRewardCustomers);
        hotelList.add(hotel);
        System.out.println("Hotel Added Successfully!!!");
    }

    @Override
    public String getCheckInDate() {
        String checkInDate;
        System.out.println("\nEnter Check-In Date");
        System.out.println("\nEnter Year in pattern like 'yyyy' for Example:- '2020'");
        System.out.println("Enter Year: ");
        String checkInDateYear;
        do {
            checkInDateYear = scan.nextLine();
        } while (checkInDateYear.isEmpty());

        System.out.println("\nEnter Month in pattern like 'mm' for Example:- '09'");
        System.out.println("Enter Month: ");
        String checkInDateMonth = scan.nextLine();

        System.out.println("\nEnter Day in pattern like 'dd' for Example:- '17'");
        System.out.println("Enter Day: ");
        String checkInDateDay = scan.nextLine();

        //Given Check-In Date by User
        checkInDate = checkInDateYear+"-"+checkInDateMonth+"-"+checkInDateDay;
        return checkInDate;
    }

    @Override
    public String getCheckInDay(String Date) throws ParseException {
        String checkInDay;
        //Create Date Object of Given Dates
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date checkIn = DateFormat.parse(Date);

        //Find Day using Date Objects
        DateFormat DayFormat = new SimpleDateFormat("EEEE");
        checkInDay = DayFormat.format(checkIn);
        return checkInDay;
    }

    @Override
    public String getCheckOutDate() {
        String checkOutDate;
        System.out.println("\nEnter Check-Out Date");
        System.out.println("\nEnter Year in pattern like 'yyyy' for Example:- '2020'");
        System.out.println("Enter Year: ");
        String checkOutDateYear;
        do {
            checkOutDateYear = scan.nextLine();
        } while (checkOutDateYear.isEmpty());

        System.out.println("\nEnter Month in pattern like 'mm' for Example:- '09'");
        System.out.println("Enter Month: ");
        String checkOutDateMonth = scan.nextLine();

        System.out.println("\nEnter Day in pattern like 'dd' for Example:- '17'");
        System.out.println("Enter Day: ");
        String checkOutDateDay = scan.nextLine();

        //Given Check-Out Date by User
        checkOutDate = checkOutDateYear+"-"+checkOutDateMonth+"-"+checkOutDateDay;
        return checkOutDate;
    }

    @Override
    public String getCheckOutDay(String Date) throws ParseException {
        String checkOutDay;
        //Create Date Object of Given Dates
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date checkOut = DateFormat.parse(Date);

        //Find Day using Date Objects
        DateFormat DayFormat = new SimpleDateFormat("EEEE");
        checkOutDay = DayFormat.format(checkOut);
        return checkOutDay;
    }

    @Override
    public int getStayDays(String checkInDate, String checkOutDate) {
        long noOfDaysBetween;
        //Creating LocalDate Object of Given Dates
        LocalDate dateBefore = LocalDate.parse(checkInDate);
        LocalDate dateAfter = LocalDate.parse(checkOutDate);

        //Calculating number of Days between Given Dates
        noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        return (int) noOfDaysBetween;
    }

    @Override
    public void findCheapestHotel() {
        HashMap<String,Integer> mapNameCost = new HashMap<>();
        ArrayList<Integer> listCost= new ArrayList<>();
        String checkInDate = getCheckInDate();
        String checkOutDate = getCheckOutDate();
        int getStayDays = getStayDays(checkInDate,checkOutDate);
        for (Hotel hotel: hotelList) {
            String hotelName = hotel.getName();
            int hotelCost = hotel.getRateForRegularCustomer() * getStayDays;
            mapNameCost.put(hotelName,hotelCost);
            listCost.add(hotelCost);
        }
        sort(listCost);
        int lowestCost = listCost.get(0);
        for (Map.Entry<String,Integer> entry : mapNameCost.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value == lowestCost) {
                System.out.println("\nBest Hotel for you is "+key);
            }
        }
    }

    @Override
    public void displayAllHotels() {
        for (Hotel hotel : hotelList) {
            System.out.println();
            System.out.println("Hotel Name: "+hotel.getName());
            System.out.println("Hotel Rating: "+hotel.getRating());
            System.out.println("Hotel Rate for Regular Customers: "+hotel.getRateForRegularCustomer());
            System.out.println("Hotel Rate for Reward Customers: "+hotel.getRateForRewardCustomer());
        }
    }
}