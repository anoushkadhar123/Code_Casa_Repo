import java.util.*;

public class guess_number {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int guessNo = new Random().nextInt(100) + 1;
            int attempts = 0, guess = 0;
            System.out.println(" ENTER A NUMBER BETWEEN 1 - 100 ");
            while (guess != guessNo) {
                System.out.print("YOUR GUESS : ");
                guess = sc.nextInt();
                attempts++;
                if (guess < guessNo) {
                    System.out.println("GO HIGHER THAN IT!!!");
                } else if (guess > guessNo) {
                    System.out.println("GO LOWER THAN IT!!!");
                }
            }
            System.out.println("YOU GUESSED IT RIGHT!!. IT TOOK YOU " + attempts + " ATTEMPTS TO GUESS!!");
        }
    }
}
