import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage extends BasePage {

    By networkLogo = new By.ByCssSelector("a.headerCheckout__logo");
    By loginButtonLocater = new By.ByCssSelector("button.n-button.large.block.text-center.-primary");
    By emailDataLocater = new By.ByXPath("//*[@id=\"n-input-email\"]");
    By passWordLocater = new By.ByXPath("//*[@id=\"n-input-password\"]");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void clickNetworkLogo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(networkLogo));
        element.click();
    }

    public Boolean checkLoginButton() {
       return isDisplayed(loginButtonLocater);
    }

    public void pullData() {
        WebElement email = driver.findElement(emailDataLocater);
        WebElement password = driver.findElement(passWordLocater);
    }
}
