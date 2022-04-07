package org.Lesson3_Maven_Web_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Test_SengMessage {

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
            WebElement message = driver.findElement(By.xpath(".//div[@dir='ltr']"));
            message.click();
            WebElement lineCRM = driver.findElement(By.xpath(".//a[@data-b24-crm-button-widget='openline_livechat' " +
                    "and @class='b24-widget-button-social-item b24-widget-button-openline_livechat']"));
            lineCRM.click();
            WebElement textarea = driver.findElement(By.xpath(".//textarea[@placeholder='Введите сообщение...' " +
                    "and @class='bx-im-textarea-input']"));
            textarea.sendKeys("CRM\n");
        } catch (NoSuchElementException | ElementNotInteractableException | StaleElementReferenceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Тест 'Отправка сообщения в CRM' пройден");

//        Завершаем работу с ресурсом
//         driver.quit();
//         driver.close();
    }
}
