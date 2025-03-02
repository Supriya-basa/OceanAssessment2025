package com.selenium.basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Login {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();


        String text = driver.findElement(By.xpath("//*[text()=\"Dashboard\"]")).getText();
        System.out.println(text);

        String title = driver.getTitle();
        if (title.equals("OrangeHRM")) {
            System.out.println("Test Passed");
        }

        

        driver.quit();


    }

}
