import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage{

    By firstProductLocater = new By.ByXPath("/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[1]/a[2]/div/div[1]");
    By showMoreLocater = new By.ByXPath("/html/body/div[3]/div/div[2]/div[2]/div[2]/button");
    By sizes = new By.ByXPath("/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[1]/div/div/div/div");
    By goToCartLocater =  new By.ByXPath("//*[@id=\"header__desktopBasket\"]/div/div[3]/a");
    By inactiveText = new By.ByXPath("/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[1]/div/div/div/div/div/span");
//    div.product.js-product-133586.gtm-added div.product__size.-productCart.radio-box span.tooltip__text

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void scrollDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,15500)", "");
    }
    public void clickShowMore() throws InterruptedException {
        click(showMoreLocater);
        Thread.sleep(3000);
    }

    //   Yoruma aldığım kısımda yaptırmak istediğim gittiği ürünün bedenlerini random sayılar üreterek gezip tıklayamadığını silmesi ve ilk tıklanabilir olanı seçmesiydi. Silme işlemini
    //   doğru yapıyor fakat else kısmına geldiğinde yani tıklanabilir olan bedeni bulduğunda tıklamıyor. Bunun nedenini çözemediğim için bedeni manuel olarak girmek zorunda kaldım.
    //   Manuel olarak Test_Add_Product_To_Cart classında 4. testte indeksi verdim. Eğer seçtiği ürün değişirse indeksi de değiştirmek gerekebiliyor bazen. O şekilde test ederseniz diğer kısımlar da çalışacaktır.

    public void selectProductSize(int i) throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(firstProductLocater);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);

        productSizes().get(i).click();

//        Random rand = new Random();
//
//        for (int i=0; i<productSizes().size();i++){
//            int randomSize = rand.nextInt(productSizes().size());
//            action.moveToElement(productSizes().get(randomSize)).build().perform();
//            Thread.sleep(2000);
//            if(productSizesAlert().get(randomSize).isDisplayed()){
//                WebElement deletedSize = productSizes().get(randomSize);
//                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//                jsExecutor.executeScript(
//                        "arguments[0].parentNode.removeChild(arguments[0])", deletedSize);
//            }
//            else{
//                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//                WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(productSizes().get(randomSize)));
//                element2.click();
//                break;
//            }
//        }
    }

    public void goToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(goToCartLocater));
        element.click();
    }
    private List<WebElement> productSizes(){
        return findAll(sizes);
    }

    private List<WebElement> productSizesAlert(){
        return findAll(inactiveText);
    }

}
