package org.Lesson3_Maven_Web_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Test_Like {

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
            WebElement likeNineNegrityat = driver.findElement(By.xpath(".//div[@class='elem_wish ' " +
                    "and @data-id='24']"));
            likeNineNegrityat.click();
            WebElement allLike = driver.findElement(By.xpath(".//a[@href='/favorite/index.php/']"));
            allLike.click();
        } catch (NoSuchElementException | ElementNotInteractableException | StaleElementReferenceException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Тест 'Лайк продукта' пройден");

//        Завершаем работу с ресурсом
//         driver.quit();
//         driver.close();
    }

}
