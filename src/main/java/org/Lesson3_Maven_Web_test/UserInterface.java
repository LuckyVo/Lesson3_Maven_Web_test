package org.Lesson3_Maven_Web_test;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    private Controller controller = new Controller();

    public void runApplication() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the test number required to check the system operation 'Xochy-Xochy':\n" +
                    "1 - User authorization;\n" +
                    "2 - Adding a product to the basket;\n" +
                    "3 - Adding a product to the Favorites section;\n" +
                    "4 - Sending a message to an open CRM line;\n" +
                    "5 - Running all tests in order.");
            String numberTest = scanner.nextLine();
            try {
                validateUserInputNumber(numberTest);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
            try {
                notifyControllerTest(numberTest);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

        }
    }

    private void validateUserInputNumber(String numberTest) throws IOException {
        if (numberTest == null || numberTest.length() != 1) {
            throw new IOException("Enter the data according to the list");
        }
        int answer = 0;
        try {
            answer = Integer.parseInt(numberTest);
        } catch (NumberFormatException e) {
            throw new IOException("It is worth entering an integer!");
        }
    }

    private void notifyControllerTest(String numberTest) throws IOException{
        controller.onUserInputNumberTest(numberTest);
    }


}
