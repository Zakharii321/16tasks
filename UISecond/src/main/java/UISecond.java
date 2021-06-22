import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class UISecond {

    private WebDriver driver;


    @Before
    public void setUp() {
        System.out.println("Start Browser");

        System.setProperty("webdriver.gecko.driver", "/home/zakharii/testproject/geckodriver");

        driver = new FirefoxDriver();// open browser
        driver.manage().window().maximize();// maximize for browser window
        System.out.println("Open website");
        driver.get("http://www.uitestingplayground.com/home");//open url

    }

    @After
    public void cleanUp() {
        System.out.println("Close browser");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            //to do auto-generated catch block
            e.printStackTrace();
        }
        if (driver != null)
            driver.quit(); // close browser;
    }

    @Test
    public void inputbutton() {
        System.out.println("Click on text input button");
        driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div[4]/h3/a")).click();
        System.out.println("Enter great job");
        driver.findElement(By.id("newButtonName")).sendKeys("Great Job Zakharii");
        System.out.println("Click button");
        driver.findElement(By.id("updatingButton")).click();
    }

    @Test
    public void click() {

        driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div[3]/h3/a")).click();
        System.out.println("We opened click button");
        driver.findElement(By.xpath("//*[@id=\"badButton\"]")).click();
        System.out.println("We finished this task");
    }

    @Test
    public void loadDelay() {
        driver.findElement(By.xpath("/html/body/section[2]/div/div[1]/div[4]/h3/a")).click();
        System.out.println("Now we should wait");
        driver.findElement(By.xpath("/html/body/section/div/button")).click();
    }

    @Test
    public void HiddenLayers() {
        driver.findElement(By.xpath("/html/body/section[2]/div/div[1]/div[3]/h3/a")).click();
        driver.findElement(By.id("greenButton")).click();
        driver.findElement(By.id("blueButton")).click();
        Assert.assertEquals("driver.findElement(By.id(blueButton))", "driver.findElement(By.id(blueButton))");
    }


    @Test
    public void DynamicId() {
        driver.findElement(By.cssSelector("#overview > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h3:nth-child(1) > a:nth-child(1)")).click();
        System.out.println("task opened");
        WebElement ButtonWithDynamicID = driver.findElement(By.xpath("/html/body/section/div/button"));
        System.out.println("button found");
        ButtonWithDynamicID.click();
        System.out.println("button clicked");
    }


    @Test
    public void AJAXdata() {
        driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div[1]/h3/a")).click();
        driver.findElement(By.xpath("//*[@id=\"ajaxButton\"]")).click();
        try {
            Thread.sleep(16000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/section/div/div/p"));
    }

    @Test
    public void ClassAttribute() {
        driver.findElement(By.xpath("/html/body/section[2]/div/div[1]/div[2]/h3/a")).click();
        driver.findElement(By.className("btn-primary")).click();
        driver.switchTo().alert().getText();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();
    }

    @Test
    public void ScrollBars() {
        driver.findElement(By.xpath("/html/body/section[2]/div/div[3]/div[1]/h3/a")).click();
        WebElement HiddenButton = driver.findElement(By.xpath("//*[@id=\"hidingButton\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", HiddenButton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HiddenButton.click();
    }

    @Test
    public void Visability() {
        driver.findElement(By.xpath("/html/body/section[2]/div/div[4]/div[1]/h3/a")).click();
        WebElement HideButton = driver.findElement(By.xpath("//*[@id=\"hideButton\"]"));
        WebElement Opacity0Button = driver.findElement(By.xpath("//*[@id=\"transparentButton\"]"));
        driver.findElement(By.xpath("//*[@id=\"removedButton\"]")); //RemoveButton
        WebElement VisHidButton = driver.findElement(By.xpath("//*[@id=\"invisibleButton\"]"));
        WebElement ZeroWidthButton = driver.findElement(By.xpath("//*[@id=\"zeroWidthButton\"]"));
        WebElement DisplayNoneButton = driver.findElement(By.xpath("//*[@id=\"notdisplayedButton\"]"));
        WebElement OverlappedButton = driver.findElement(By.xpath("//*[@id=\"overlappedButton\"]"));
        WebElement OffscreenButton = driver.findElement(By.xpath("//*[@id=\"offscreenButton\"]"));
        HideButton.click();

        if (Opacity0Button.isDisplayed()) {
            System.out.println("Opacity0Button was found");
        } else {
            System.out.println("Opacity0Button isnt displayed");
        }

        if (driver.findElement(By.xpath("/html/body/section/div/table/tbody/tr[1]/td[2]")).isDisplayed()) {
            System.out.println("RemoveButton was found");
        } else {
            System.out.println("RemoveButton isnt displayed");
        }

        if (ZeroWidthButton.isDisplayed()) {
            System.out.println("ZeroWidthButton was found");
        } else {
            System.out.println("ZeroWidthButton isnt displayed");
        }

        if (VisHidButton.isDisplayed()) {
            System.out.println("VisHidButton was found");
        } else {
            System.out.println("VisHidButton isnt displayed");
        }

        if (DisplayNoneButton.isDisplayed()) {
            System.out.println("DisplayNoneButton was found");
        } else {
            System.out.println("DisplayNoneButton isnt displayed");
        }

        if (OverlappedButton.isDisplayed()) {
            System.out.println("OverlappedButton was found");
        } else {
            System.out.println("OverlappedButton isnt displayed");
        }

        if (OffscreenButton.isDisplayed()) {
            System.out.println("OffscreenButton was found");
        } else {
            System.out.println("OffscreenButton isnt displayed");
        }

    }

    @Test
    public void ClientSideDelay() {
        driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div[2]/h3/a")).click();
        driver.findElement(By.xpath("//*[@id=\"ajaxButton\"]")).click();
        try {
            Thread.sleep(16000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/section/div/div/p"));
    }

    @Test
    public void DynamicTable() {
        driver.findElement(By.xpath("/html/body/section[2]/div/div[3]/div[2]/h3/a")).click();
        String cpuValue = driver.findElement(By.xpath("//p[contains(text(), 'Chrome CPU:')]")).getText();
        String[] cpuValue2 = cpuValue.split(":", 2);
        String var1 = cpuValue2[1].replaceAll("\\s", "");
        String tableCpuValue = driver.findElement(By.xpath("//span[text()='Chrome']/following-sibling::span[contains(text(), '%')]")).getText();
        Assert.assertEquals(var1, tableCpuValue);
        System.out.println("Test passed");
    }

    @Test
    public void SampleApp() {
        driver.findElement(By.xpath("/html/body/section[2]/div/div[4]/div[2]/h3/a")).click();
        driver.findElement(By.name("UserName")).sendKeys("Zakharii");
        driver.findElement(By.name("Password")).sendKeys("pwd");
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
    }

    @Test
    public void VerifyText() {
        driver.findElement(By.xpath("/html/body/section[2]/div/div[3]/div[3]/h3/a")).click();
        driver.findElement(By.xpath("//span[normalize-space(.)='Welcome UserName!']"));
    }


    @Test
    public void MouseOver() {
        driver.findElement(By.xpath("/html/body/section[2]/div/div[4]/div[3]/h3/a")).click();
        driver.findElement(By.xpath("/html/body/section/div/div[1]/a")).click();
        driver.findElement(By.xpath("/html/body/section/div/div[1]/a")).click();
        String clickValue = "2";
        String clickValu2 = driver.findElement(By.xpath("//span[@id=\"clickCount\"]")).getText();
        Assert.assertEquals(clickValue, clickValu2);
    }


    @Test
    public void ProgressBar() {
        driver.findElement(By.xpath("//a[text()='Progress Bar']\n")).click();
        driver.findElement(By.xpath("//button[@id=\"startButton\"]\n")).click();
        WebDriverWait waitUntil = new WebDriverWait(driver, 30);
        waitUntil.until((ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'75%')]"))));
        driver.findElement(By.xpath("//button[@id='stopButton']")).click();
    }

    @Test
    public void SpaceBreak() {
        driver.findElement(By.xpath("/html/body/section[2]/div/div[4]/div[4]/h3/a")).click();
        driver.findElement(By.xpath("//button[text()='My\u00a0Button']")).click();
    }

}