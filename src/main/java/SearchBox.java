import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchBox extends BasePage{

    By searchBoxLocater = By.id("search");

    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        type(searchBoxLocater,text);
        driver.findElement(By.id("search")).sendKeys(Keys.ENTER);
    }
}
