
/**
 * ONLINE RESERVATION SYSTEM
 * This Online Reservation System will include all the necessary fields which are required
 * during online reservation system. This Online Reservation System will be easy to use and can be
 * used by any person. The basic idea behind this project is to save data in a central database which can be
 * accessed by any authorize person to get information and saves time and burden which are being
 * faced by their customers.

 * Modules
 * Login Form – To access this Online Reservation System, each user should have a valid login id and
 * password. After providing the correct login id and password, users will able to access the main
 * system.
 * Reservation System – Under reservation form users will have to fill the necessary details such as
 * their basic details, train number, train name will automatically come in the box, class type, date of
 * journey, from (place) to destination and after that, users will have to press insert button.
 * Cancellation Form – If passengers want to cancel their tickets then they have to provide their
 * PNR number and after submitting it, this will display the entire information related to that
 * particular PNR number. If users want to confirm their cancellation, in this case they have to press
 * OK button.
 */

import java.util.*;

class OnlineReservation {
    public static void main(String args[]) {
        boolean b = true;
        boolean seat[] = new boolean[10];
        String user_name_data[] = { "abcd", "hey", "admin" };
        String password_data[] = { "123", "abc123", "987abc" };
        Scanner sc = new Scanner(System.in); 
            System.out.println("Enter your username....");
            String user_name = sc.nextLine();
            System.out.println("Enter your password....");
            String password = sc.nextLine();
            boolean flag = login_check(user_name_data, password_data, user_name, password);
            if (flag) {
                System.out.println("LOGGED IN SUCCESFULLY");
                while (b) {
                    System.out.println("1. RESERVATION");
                    System.out.println("2. CANCELLATION");
                    System.out.println("3. EXIT");
                    int ch = sc.nextInt();
                    switch (ch) {
                        case 1: reservation(seat);
                            break;

                        case 2: cancellation(seat);
                            break;

                        case 3: b = false;
                            break;
                        default:
                            System.out.println("WRONG CHOICE, PLEASE TRY AGAIN !");
                    }
                }
            }

            else
                System.out.println("LOGIN ATTEMPT FAILED !");
        }

    public static boolean login_check(String user_name_data[], String password_data[], String user_name,
            String password) {
        for (int i = 0; i < user_name_data.length; i++) {
            if ((user_name_data[i].equals(user_name)) && (password_data[i].equals(password)))
                return true;
        }
        return false;
    }

    public static void reservation(boolean seat[]) {
        System.out.println("SEATS AVAILABLE : ");
        for (int i = 0; i < seat.length; i++) {
            if (seat[i] == false) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
        System.out.println("SELECT A SEAT FOR RESERVATION : ");
        Scanner sc = new Scanner(System.in); 
            int seat_no = sc.nextInt();
            if (seat_no >= 10) {
                System.out.println("No such seat is available !");
            } else {
                if (seat[seat_no - 1] == false) {
                    seat[seat_no - 1] = true;
                    System.out.println("Seat Booked Successfully !!");
                }
                else {
                    System.out.println("No such seat is available !");
                }
            }
    }

    public static void cancellation(boolean seat[]) {
        System.out.println("SELECT A SEAT FOR CANCELLATION :");
        Scanner sc = new Scanner(System.in);
            int seat_no = sc.nextInt();
            if(seat_no >= 1 && seat_no <= 10)
            {
                if(seat[seat_no - 1] == true)
            {
                seat[seat_no - 1] = false;
                System.out.println("Seat Cancelled Successfully !");
            }
            else {
                System.out.println("No such seat is available ! ");
            }
            }
            else {
                System.out.println("No such seats can be cancelled !");
            }
    }
}