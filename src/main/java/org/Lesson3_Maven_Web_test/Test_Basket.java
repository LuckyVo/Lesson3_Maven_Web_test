package org.Lesson3_Maven_Web_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Test_Basket {

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
            WebElement catalog = driver.findElement(By.xpath(".//a[@href='/catalog/']"));
            catalog.click();
            WebElement cookies = driver.findElement(By.xpath(".//a[@href='/catalog/pechenye/' " +
                    "and @class='front_cont w_more_h']"));
            cookies.click();
            WebElement nineNegrityat = driver.findElement(By.xpath(".//a[@href='/catalog/pechenye/9-negrityat/']"));
            nineNegrityat.click();
            WebElement toBasket = driver.findElement(By.xpath(".//button[@data-js='button-buy' " +
                    "and contains(., 'В корзину')]"));
            toBasket.click();
            WebElement basket = driver.findElement(By.xpath(".//a[@href='/basket/' " +
                    "and @class='button-ux main-ux solid checkout']"));
            basket.click();
        } catch (NoSuchElementException | ElementNotInteractableException | StaleElementReferenceException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Тест 'Корзина' пройден");

//        Завершаем работу с ресурсом
//         driver.quit();
//         driver.close();
    }
}
