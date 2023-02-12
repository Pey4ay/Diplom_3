import com.codeborne.selenide.WebDriverRunner;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import pom.HomePage;
import pom.LoginPage;
import pom.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class RegistrationUserTest {
    private LoginPage loginPage = page(LoginPage.class);
    private RegistrationPage registrationPage = page(RegistrationPage.class);
    private HomePage homePage = page(HomePage.class);

    @Before
    public void setUp() {
        HomePage homePage = open(Constants.BASE_URL, HomePage.class);
    }

    @Test
    public void createNewUserTest() {
        homePage.clickEnterToAccountButton();
        loginPage.clickRegistrationPageLink();
        registrationPage.setUserData(UserGenerator.nameRandom, UserGenerator.emailRandom, UserGenerator.passwordRandom);
        registrationPage.clickRegistrationButton();
        loginPage.checkRecoveryPassButton();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(Constants.LOGIN_URL, currentUrl);
    }

    @Test
    public void checkPasswordLengthErrorTest() {
        homePage.clickEnterToAccountButton();
        loginPage.clickRegistrationPageLink();
        registrationPage.setUserData(UserGenerator.incorrectName, UserGenerator.incorrectEmail, UserGenerator.incorrectPassword);
        registrationPage.clickRegistrationButton();
        registrationPage.checkPasswordErrorMsgDisplayed();
    }

    @AfterClass
    public static void closeDriver() {
        closeWebDriver();
    }
}
