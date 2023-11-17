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
