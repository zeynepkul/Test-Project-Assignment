import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement find(By locater){
        return driver.findElement(locater);
    }

    public List<WebElement> findAll(By locater){
        return driver.findElements(locater);
    }

    public void click(By locater){
        find(locater).click();
    }

    public void type(By locater, String text){
        find(locater).sendKeys(text);
    }

    public Boolean isDisplayed(By locater){
        return find(locater).isDisplayed();
    }


}
