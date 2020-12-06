import java.util.Scanner;

public class HotelReservationMain extends HotelServicesImplementation {
    public static void main(String[] args) {
        HotelServicesList myHotel = new HotelServicesImplementation();
        Scanner scan = new Scanner(System.in);
        boolean mainEntry = true;
        while (mainEntry) {
            System.out.println("**********Welcome to Hotel Reservation**********");
            System.out.println();
            System.out.println("""
                    1. Add Hotel
                    2. Display All Hotels
                    3. Quit Application""");
            String usr_choice = scan.nextLine();
            switch (usr_choice) {
                case "1":
                    myHotel.addHotel();
                    break;
                case "2":
                    myHotel.displayAllHotels();
                    break;
                case "3":
                    mainEntry = false;
                    break;
                default:
                    System.out.println("Enter Valid Option!!!");
            }
        }
    }
}
