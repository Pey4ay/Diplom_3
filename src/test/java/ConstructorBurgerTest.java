import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pom.HomePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class ConstructorBurgerTest {
    private HomePage homePage = page(HomePage.class);

    @Before
    public void setUp() {
        HomePage homePage = open(Constants.BASE_URL, HomePage.class);
    }

    @Test
    public void clickToBuns(){
        homePage.clickToppings();
        homePage.clickBun();
        Assert.assertEquals("Булки", homePage.getCurrentTabText());
    }

    @Test
    public void clickToSauce(){
        homePage.clickSauce();
        Assert.assertEquals("Соусы", homePage.getCurrentTabText());
    }

    @Test
    public void clickToToppings(){
        homePage.clickToppings();
        Assert.assertEquals("Начинки", homePage.getCurrentTabText());
    }
}
