import java.util.*;

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