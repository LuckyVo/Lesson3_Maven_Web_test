package org.Lesson3_Maven_Web_test;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    private Controller controller = new Controller();

    public void runApplication() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер теста необходимого для проверки работы системы 'Хочу-Хочу':\n" +
                    "1 - Авторизация пользователя;\n" +
                    "2 - Добавление продукта в корзину;\n" +
                    "3 - Добавление продукта в раздел 'Избранное';\n" +
                    "4 - Отправка сообщения открытой линии CRM;\n" +
                    "5 - Выполнение всех тестов по порядку.");
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
            throw new IOException("Введите данные согласно списку");
        }
        int answer = 0;
        try {
            answer = Integer.parseInt(numberTest);
        } catch (NumberFormatException e) {
            throw new IOException("Стоит ввести целое число!");
        }
    }

    private void notifyControllerTest(String numberTest) throws IOException{
        controller.onUserInputNumberTest(numberTest);
    }


}
