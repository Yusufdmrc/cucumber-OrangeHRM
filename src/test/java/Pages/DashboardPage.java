package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;

public class DashboardPage {
    WebDriver driver;
    util.ElementHelper elementHelper;
    WebDriverWait wait;
    public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        this.elementHelper = new util.ElementHelper(driver);}
    By MyInfoButton = By.cssSelector("a[class='oxd-main-menu-item active'] span[class='oxd-text oxd-text--span oxd-main-menu-item--name']");

    By SaveButton = By.cssSelector("div[class='orangehrm-horizontal-padding orangehrm-vertical-padding'] button[type='submit']");
    By NameAndSurnameTitle = By.cssSelector(".oxd-userdropdown-name");

    public void clickToMyInfo() {
        driver.findElement(MyInfoButton).click();
    }

    public void changeNameAndSurname() {
        WebElement Username = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div/div/div[2]/div[1]/div[2]/input"));
        Username.sendKeys(Keys.CONTROL+"a");
        Username.sendKeys(Keys.DELETE);
        Username.sendKeys("Yusuf");

        WebElement Surname = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div/div/div[2]/div[3]/div[2]/input"));
        Surname.sendKeys(Keys.CONTROL+"a");
        Surname.sendKeys(Keys.DELETE);
        Surname.sendKeys("Demirci");
    }

    public void clickToSaveButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        driver.findElement(SaveButton).click();
    }

    public void checkNewNameAndSurname() {
        driver.findElement(MyInfoButton).click();
        WebElement NewNameAndSurname = driver.findElement(NameAndSurnameTitle);
        String NewNameAndSurnameText = NewNameAndSurname.getText();
        assertEquals(NewNameAndSurnameText,"Yusuf Demirci");
    }
}
