package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase04 {
    WebDriver driver;
    public TestCase04()
    {
        System.out.println("Constructor: TestCase1");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
    public  void testCase04() throws InterruptedException{
        System.out.println("Test case to automate irctcfrom station first result");
        System.out.println("Start Test case: testCase04");
        driver.get("https://www.irctc.co.in/");
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@role='searchbox']")).click();
        WebElement first=driver.findElement(By.xpath("(//ul[@role='listbox']//li)[2]//span"));
        System.out.println("First result on from station="+first.getText());
        System.out.println("End Test case: testCase04");
            }
}
        