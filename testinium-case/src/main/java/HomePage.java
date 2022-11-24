import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage extends BasePage{

    SearchBox searchBox;
    By cartCountLocater = By.id("header__basket--count");
    By acceptCoocieksLocater = By.id("onetrust-accept-btn-handler");
//    By goToCartLocater =  new By.ByCssSelector("a.button.-primary.header__basket--checkout.header__basketModal.-checkout");
//    By cartContainerIconLocater = new By.ByCssSelector("a.header__basketMobile");
    By bagLogoLocater = new By.ByCssSelector("svg.header__icon.-shoppingBag");
    By deleteIconLocater = new By.ByCssSelector("div.header__basketProductBtn.header__basketModal.-remove svg.header__basketProductRemove");
    By removeButtonLocater = new By.ByCssSelector("button.btn.-black.o-removeCartModal__button");
    By emptyCartButtonLocater = new By.ByCssSelector("button.header__emptyBasketShopping.button.-secondary");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    public void acceptCookies(){
        if (isDisplayed(acceptCoocieksLocater)){
            click(acceptCoocieksLocater);
        }
    }

    public void clickBagLogo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(bagLogoLocater));
        element.click();
    }

    public void removeProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(deleteIconLocater));
        element.click();
    }

    public void removeProductToCartToApprove() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(removeButtonLocater));
        Thread.sleep(2000);
        element.click();
    }

    public Boolean checkCartIsEmpty() {
        return isDisplayed(emptyCartButtonLocater);
    }
}
