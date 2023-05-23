package UserInput;

import java.util.List;
import java.util.Scanner;

public class userInput {

    public static String userStringInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();
        System.out.println(name);
        
        System.out.print("숫자를 입력하세요: ");
        int numberData = scanner.nextInt();
        System.out.println(numberData);

        scanner.close();
        return name;
    }
    
    public static void userInputLoop() {

        Scanner scanner = new Scanner(System.in);

        boolean shouldContinue = true;
        
        while (shouldContinue) {
            System.out.print("값을 입력하세요 (종료하려면 'exit' 입력): ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                shouldContinue = false;
            } else {
                System.out.println("입력된 값: " + input);
            }
        }

        scanner.close();
    }
	

	public static void main(String[] args) {
		String inputData = userStringInput();
		userInputLoop();
	}
	
}
