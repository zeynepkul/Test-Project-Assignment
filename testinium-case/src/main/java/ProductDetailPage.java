import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductDetailPage extends BasePage{

    By addToCartButtonLocater = new By.ByCssSelector("button.-addToCart");
    By productSizeLocater = new By.ByCssSelector("label.radio-box__label");
//    By goToCartLocater =  new By.ByXPath("//*[@id=\"header__desktopBasket\"]/div/div[3]/a");
//    By a = new By.ByCssSelector("div.header__basketProductList.-scrollOne");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

//    public void selectSize() {
//        getAllSize().get(6).click();
//    }

    public void addToCart() {
        click(addToCartButtonLocater);
    }

//    public void goToCart() {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(goToCartLocater));
//            element.click();
//    }

    private List<WebElement> getAllSize(){
        return findAll(productSizeLocater);
    }



}
