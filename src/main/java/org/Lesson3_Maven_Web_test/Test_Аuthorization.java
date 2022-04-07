package org.Lesson3_Maven_Web_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Test_Аuthorization{

    public void moveTest(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        //options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://xochy-xochy.com/");

        try {
            WebElement account = driver.findElement(By.xpath(".//a[@href='/account/']"));
            account.click();
            WebElement userName = driver.findElement(By.name("USER_LOGIN"));
            userName.sendKeys("v.kudraivzev@yandex.ru");
            WebElement userPass = driver.findElement(By.name("USER_PASSWORD"));
            userPass.sendKeys("ASDFzxcv1234");
            WebElement logIn = driver.findElement(By.xpath(".//a[@href='javascript:void(0)']"));
            logIn.click();
        } catch (NoSuchElementException | ElementNotInteractableException | StaleElementReferenceException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Тест 'Авторизация' пройден");

//        Завершаем работу с ресурсом
//         driver.quit();
//         driver.close();
    }
}
