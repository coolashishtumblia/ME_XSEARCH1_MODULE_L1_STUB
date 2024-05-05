
package apTests;

import java.util.List;
import java.util.concurrent.TimeUnit;
//Selenium Imports
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
///

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {    
    WebDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // options.addArguments("start-maximized");
        // options.addArguments("--disable-blink-features=AutomationControlled");

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
    public void logstatus(String msg){
        System.out.println(msg);
    }
    public void launchbrowser(){
        driver.get("https://www.makemytrip.com/ ");
    }

    public void testCase01() {
        logstatus("Start Test case: testCase01");
        launchbrowser();
        String currenturl= driver.getCurrentUrl().toLowerCase();
        if(currenturl.contains("makemytrip")){
            logstatus("TestCase 01: PASSED");
        }
        else{
            logstatus("TestCase 02: FAILED");
        }
        logstatus("end Test case: testCase01");
    }
    public void testCase02() throws InterruptedException {
        logstatus("Start Test Case: TestCase02");
        // driver.switchTo().defaultContent ();
        Thread.sleep(10000);
        WebElement From=driver.findElement(By.xpath("//span[text()='From']"));
        From.click();
        driver.switchTo().defaultContent(); 
        WebElement Fcity=driver.findElement(By.xpath("//input[@placeholder='From']"));
        Fcity.sendKeys("BLR");
        WebElement departure=driver.findElement(By.xpath("//span[@class='makeFlex flexOne spaceBetween appendRight10']/span[text()='Bengaluru']"));
        departure.click();
        WebElement To=driver.findElement(By.xpath("//span[text()='To']"));
        To.click();
        WebElement Tcity=driver.findElement(By.xpath("//input[@placeholder='To']"));
        Tcity.sendKeys("DEL");
        WebElement arrival=driver.findElement(By.xpath("//span[@class='makeFlex flexOne spaceBetween appendRight10']/span[text()='New Delhi']"));
        arrival.click();
        WebElement departureDate=driver.findElement(By.xpath("//div[@aria-label='Sat Jun 29 2024']"));
        departureDate.click();
        // Thread.sleep(3000);
        WebElement searchButton=driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']"));
        searchButton.click();
        // Thread.sleep(5000);
        List<WebElement>  pricePerAduList=driver.findElements(By.xpath("//div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice']"));
        for(WebElement flight: pricePerAduList){
            Thread.sleep(2000);
            String s=flight.getText();
            System.out.println(s);
            
        }
            
        if(pricePerAduList.size()==0){
            logstatus("TestCase02: FAILED");
        }
        else{
            logstatus("TestCase02: PASSED");
        }
        
        logstatus("end Test Case: TestCase02");
    }
    public void testCase03()throws InterruptedException{
        logstatus("Start Test Case: TestCase03");
        Thread.sleep(10000);
        WebElement Trains=driver.findElement(By.xpath("//span[text()='Trains']"));
        Trains.click();
        WebElement from=driver.findElement(By.xpath("//span[text()='From']"));
        from.click();
        WebElement Fcity=driver.findElement(By.xpath("//input[@placeholder='From']"));
        Fcity.sendKeys("YPR");
        WebElement departure=driver.findElement(By.xpath("//span[@class='sr_iata grayText latoBold pushRight' and text()='YPR']"));
        departure.click();
        WebElement to=driver.findElement(By.xpath("//span[text()='To']"));
        to.click();
        WebElement Tcity=driver.findElement(By.xpath("//input[@placeholder='To']"));
        Tcity.sendKeys("NDLS");
        WebElement arrival=driver.findElement(By.xpath("//span[@class='sr_iata grayText latoBold pushRight' and text()='NDLS']"));
        arrival.click();
        WebElement date=driver.findElement(By.xpath("//div[@class='rsw_inputBox dayPickerRailWrap dates']"));
        date.click();
        WebElement departureDate=driver.findElement(By.xpath("//div[@aria-label='Sat Jun 29 2024']"));
        departureDate.click();
        WebElement trainClass=driver.findElement(By.xpath("//div[@class='code latoBlack font32 blackText makeRelative']"));
        trainClass.click();
        WebElement classes=driver.findElement(By.xpath("//ul[@class='travelForPopup']/li[@data-cy='3A']"));
        classes.click();
        WebElement submit=driver.findElement(By.xpath("//a[@data-cy='submit']"));
        submit.click();
        List<WebElement>  ThirdAC=driver.findElements(By.xpath("//div[@id='train_options_29-04-2024_0']/div/div[2]"));
        for(WebElement train: ThirdAC){
            String s=train.getText();
            System.out.println(s);
            
        }
        if(ThirdAC.size()==0){
            logstatus("TestCase03: FAILED");
        }
        else{
            logstatus("TestCase03: PASSED");
        }
        logstatus("end Test Case: TestCase03");

    }
    public void testCase04()throws InterruptedException{
        logstatus("Start Test Case: TestCase04");
        Thread.sleep(5000);
        WebElement Bus=driver.findElement(By.xpath("//a[@href='https://www.makemytrip.com/bus-tickets/']"));
        Bus.click();
        WebElement from=driver.findElement(By.xpath("//input[@id='fromCity']"));
        from.click();
        WebElement Fcity=driver.findElement(By.xpath("//input[@id='fromCity']"));
        Fcity.sendKeys("bangl");
        WebElement departure=driver.findElement(By.xpath("//span[text()='Bangalore, Karnataka']"));
        departure.click();
        WebElement to=driver.findElement(By.xpath("//input[@placeholder='To']"));
        to.click();
        WebElement Tcity=driver.findElement(By.xpath("//input[@placeholder='To']"));
        Tcity.sendKeys("ran");
        WebElement arrival=driver.findElement(By.xpath("//span[text()='Ranchi, Jharkhand']"));
        arrival.click();
        WebElement departureDate=driver.findElement(By.xpath("//div[@aria-label='Wed May 29 2024']"));
        departureDate.click();
        WebElement submit=driver.findElement(By.xpath("//button[@id='search_button']"));
        submit.click();
        WebElement Buses=driver.findElement(By.xpath("//span[@class='error-title']"));
            String s=Buses.getText();
            System.out.println(s);
            
        
        if(s.contains("No buses found for 29 May")){
            logstatus("TestCase04: PASSED");
        }
        else{
            logstatus("TestCase04: FAILED");
        }
        logstatus("end Test Case: TestCase04");

    }
    

}

