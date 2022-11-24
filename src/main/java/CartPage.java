import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage{

    By productNameLocater = new By.ByCssSelector("div.cartItem__content img.img-fluid");
    By continueButtonLocater = new By.ByXPath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div/div[2]/button");
    By productsPagePriceLocater = new By.ByXPath("/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/div[2]/div/span[2]");
    By cartPagePriceLocater = new By.ByXPath("/html/body/div[1]/div/div[1]/div[1]/div[1]/div[2]/section/div[3]/div/div/div[1]/div[3]/span[1]");
    By salePriceLocater = new By.ByCssSelector("span.cartItem__price.-sale");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfProductAdded() {
        return getProducts().size() > 0;
    }

    private List<WebElement> getProducts(){
        return findAll(productNameLocater);
    }

    public void checkSizeAndPriceCorrect() {

    }

    public void clickContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocater));
        element.click();
    }

    public void discountPriceAndNormalPrice() {

    }
}
