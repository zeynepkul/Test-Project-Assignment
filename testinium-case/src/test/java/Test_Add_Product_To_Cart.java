import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class Test_Add_Product_To_Cart extends BaseTest{

    HomePage homePage;
    ProductsPage productsPage;
    CartPage cartPage;
    SignUpPage signUpPage;

//  Network url’nin geldiği kontrol edilir.
    @Test
    @Order(1)
    public void getURL(){
        String expectedURL = driver.getCurrentUrl();
        Assertions.assertEquals(expectedURL, "https://www.network.com.tr/",
                "Incorrect URL");
    }

//  Arama sekmesinde “ceket” yazdırılır ve arama yaptırılır
    @Test
    @Order(2)
    public void searchProduct(){
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        homePage.acceptCookies();
        homePage.searchBox().search("ceket");
        String expectedURL = driver.getCurrentUrl();
        Assertions.assertEquals(expectedURL, "https://www.network.com.tr/search?searchKey=ceket",
                "Not on products page!");
    }

//  Ürün listeme sayfasında daha fazla göster butonuna kadar scroll yapılır
//  2.sayfaya geçildiği kontrol edilir(url değişiyor).
    @Test
    @Order(3)
    public void scroll() throws InterruptedException {
        productsPage.scrollDown();
        productsPage.clickShowMore();
        String expectedURL = driver.getCurrentUrl();
        Assertions.assertEquals(expectedURL, "https://www.network.com.tr/search?searchKey=ceket&page=2",
                "Not on second page!");
    }

//  Ürün listeme sayfasında İndirimli ilk ürüne hover edilerek rastgele beden seçimi yapılır
    @Test
    @Order(4)
    public void selectAProductSize() throws InterruptedException {
        productsPage.selectProductSize(6);
    }

//  Sağ alt köşede açılan Sepete git butonu seçilir.
    @Test
    @Order(5)
    public void goToCart(){
        productsPage.goToCart();
    }

//  Ürüne ait beden ve fiyat bilgisinin sepette doğru geldiği kontrol edilir.
    @Test
    @Order(6)
    public void checkSizeAndPriceCorrect(){
        cartPage = new CartPage(driver);
        cartPage.checkSizeAndPriceCorrect();
    }

//  Sepete eklen ürünün eski fiyatının indirimli fiyatından büyük olduğu kontrol ettirilir.
    @Test
    @Order(7)
    public void checkDiscountPriceLessThanNormalPrice(){
        cartPage.discountPriceAndNormalPrice();
    }

//  Devam et butonuna tıklanır.
    @Test
    @Order(8)
    public void clickContinueButton(){
        cartPage.clickContinueButton();
    }

//    Kullanıcı bilgileri csv formatından çekilerek doldurulur (E-posta - şifre csv uzantılı dosyadan okunması gerekmektedir.)
//    public void pullData(){
//        signUpPage = new SignUpPage(driver);
//        signUpPage.pullData();
//    }

//  Giriş yap butonunun geldiği kontrol edilir.
    @Test
    @Order(9)
    public void checkLoginButton(){
        signUpPage = new SignUpPage(driver);
        signUpPage.checkLoginButton();
    }

//  Network logosuna tıklanır.
    @Test
    @Order(10)
    public void clickNetworkLogo(){
        signUpPage.clickNetworkLogo();
    }

//  Anasayfa üzerinde çanta logosuna tıklanarak Sepetim ekranın sağ tarafında açılır
    @Test
    @Order(11)
    public void clickBagLogo(){
        homePage.clickBagLogo();
    }

//  Ürün sepetten çıkarılarak sepetin boş olduğu kontrol edilir.
    @Test
    @Order(12)
    public void removeProductToCart() throws InterruptedException {
        homePage.removeProductToCart();
        homePage.removeProductToCartToApprove();
        homePage.checkCartIsEmpty();
    }

}
