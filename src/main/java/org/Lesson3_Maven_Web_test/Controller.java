package org.Lesson3_Maven_Web_test;

import org.ENUM.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    Map<Integer, Functionality> variantResult = new HashMap();
    Test_Аuthorization testAuth = new Test_Аuthorization();
    Test_Basket testBasket = new Test_Basket();
    Test_Like testLike = new Test_Like();
    Test_SengMessage testSengMessage = new Test_SengMessage();

    public Controller() {
        variantResult.put(1, Functionality.АUTHORIZATION);
        variantResult.put(2, Functionality.BASKET);
        variantResult.put(3, Functionality.LIKE_PRODUCT);
        variantResult.put(4, Functionality.SEND_MESSAGE);
        variantResult.put(5, Functionality.ALL);
    }

    public void onUserInputNumberTest(String numberTest) throws IOException {
        int command = Integer.parseInt(numberTest);
        if (!variantResult.containsKey(command)) {
            throw new IOException("Entered the missing command!");
        }

        switch (variantResult.get(command)) {
            case АUTHORIZATION: runTestАuthorization();
                break;
            case BASKET: runTestBasket();
                break;
            case LIKE_PRODUCT: runTestLike();
                break;
            case SEND_MESSAGE: runTestSengMessage();
                break;
            case ALL: allTest();
                break;
        }
    }

    private void runTestАuthorization(){
        testAuth.moveTest();
    }

    private void runTestBasket(){
        testBasket.moveTest();
    }

    private void runTestLike(){
        testLike.moveTest();
    }

    private void runTestSengMessage(){
        testSengMessage.moveTest();
    }

    private void allTest(){
        runTestАuthorization();
        runTestBasket();
        runTestLike();
        runTestSengMessage();
    }
}
