package demo;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcases{
    WebDriver driver;
    public Testcases()
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
    public  void Bookmyshow() throws InterruptedException{
      System.out.println("Start Test case: Bookmyshow");
      driver.get("https://in.bookmyshow.com/");
      driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
      int numofhyp=driver.findElements(By.xpath("//a[@href]")).size();
      System.out.println("Total number of hyperlinks present==" + numofhyp);
      Thread.sleep(500);
      System.out.println("End Test case: Bookmyshow");  
      }
      public  void Heroku() throws InterruptedException{
        System.out.println("Start Test case: Heroku");
        driver.get("https://the-internet.herokuapp.com/nested_frames");
            driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
      List<WebElement> paframes = driver.findElements(By.tagName("frame"));
           for(WebElement frames:paframes)
           {
            driver.switchTo().frame(frames);
            List<WebElement> innrframe = driver.findElements(By.tagName("frame"));

            if(innrframe.size()==0)
            {
                WebElement text=driver.findElement(By.tagName("body"));
                System.out.println("Parent frame text with out child=" + text.getText());
            }
            else
            {
            
           for(WebElement ch:innrframe)
                {
                    driver.switchTo().frame(ch);
                    WebElement text=driver.findElement(By.tagName("body"));
                     System.out.println("Parent inner child text=" + text.getText());
                     driver.switchTo().parentFrame();

                }
               driver.switchTo().parentFrame();
             
            }
         }
        System.out.println("End Test case: Heroku");
   }
   public  void W3schools() throws InterruptedException{
    System.out.println("Start Test case: W3schools");
    driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
     WebElement iframe=driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
     driver.switchTo().frame(iframe);

     driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
     driver.switchTo().alert().sendKeys("Roopa");
    
     driver.switchTo().alert().accept();
     Thread.sleep(1000);
     String str=driver.findElement(By.xpath("//p[@id='demo']")).getText();
     System.out.println(str);
     System.out.println("End Test case: W3schools");
   }
   public  void W3schools1() throws InterruptedException{
    System.out.println("Start Test case: W3schools1");
    driver.get("https://www.w3schools.com/");
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        
        driver.findElement(By.id("cert_navbtn")).click();
        //Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
         Iterator<String> iterator = allWindowHandles.iterator();
         while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
              System.out.println("Current url of the page=" + driver.getCurrentUrl());

                }
            }
            System.out.println("End Test case: W3schools1");
  }
  public  void IMDBS() throws InterruptedException{
    System.out.println("Start Test case: IMDBS");
    driver.get("https://www.imdb.com/chart/top");
    driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    driver.findElement(By.tagName("select")).click();
    driver.findElement(By.xpath(" //select//option[2]")).click();
    Thread.sleep(3000);
    String tx=driver.findElement(By.xpath("//div[@class='desc']//span")).getText();
    System.out.println("Total number of movies="+tx);
    String tx1=driver.findElement(By.xpath("(//td[@class='titleColumn'])[1]//a")).getText();
    System.out.println("Highest rating movie="+tx1);
    driver.findElement(By.xpath("//span[@title='Descending order']")).click();
    String tx2=driver.findElement(By.xpath("(//td[@class='titleColumn'])[1]//a")).getText();
    System.out.println("Lowest rating movie="+tx2);
    System.out.println("End Test case: IMDBS");

}
}
        