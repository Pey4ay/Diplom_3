import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pom.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class NavigationUserTest {
    private LoginPage loginPage = page(LoginPage.class);
    private RegistrationPage registrationPage = page(RegistrationPage.class);
    private HomePage homePage = page(HomePage.class);
    private PasswordRestorePage passwordRestorePage = page(PasswordRestorePage.class);
    private ProfilePage profilePage = page(ProfilePage.class);

    @Before
    public void setUp() {
        HomePage homePage = open(Constants.BASE_URL, HomePage.class);
    }

    // вход по кнопке «Войти в аккаунт» на главной,
    @Test
    public void loginWithEnterToAccountButtonTest() {
        HomePage homePage = page(HomePage.class);
        LoginPage loginPage = page(LoginPage.class);
        homePage.clickEnterToAccountButton();
        loginPage.setUserData(UserGenerator.email, UserGenerator.password);
        loginPage.clickLoginButton();
        homePage.checkCreateOrderButton();
    }

    // вход через кнопку «Личный кабинет»,
    @Test
    public void loginWithAccountButtonTest() {
        homePage.clickAccountButton();
        loginPage.setUserData(UserGenerator.email, UserGenerator.password);
        loginPage.clickLoginButton();
        homePage.checkCreateOrderButton();
    }

    // вход через кнопку в форме регистрации
    @Test
    public void loginWithEnterToAccountButtonOnRegFormTest() {
        homePage.clickEnterToAccountButton();
        loginPage.clickRegistrationPageLink();
        registrationPage.clickLoginPageLink();
        loginPage.setUserData(UserGenerator.email, UserGenerator.password);
        loginPage.clickLoginButton();
        homePage.checkCreateOrderButton();
    }

    // вход через кнопку в форме восстановления пароля
    @Test
    public void loginWithEnterToAccountButtonOnResetPasswordFormTest() {
        homePage.clickEnterToAccountButton();
        loginPage.clickRecoveryPassButton();
        passwordRestorePage.clickLoginPageLink();
        loginPage.setUserData(UserGenerator.email, UserGenerator.password);
        loginPage.clickLoginButton();
        homePage.checkCreateOrderButton();
    }

    // Переход в личный кабинет
    @Test
    public void openUserAccountTest() {
        homePage.clickAccountButton();
        loginPage.setUserData(UserGenerator.email, UserGenerator.password);
        loginPage.clickLoginButton();
        homePage.clickAccountButton();
        profilePage.checkIfInputVisible();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(Constants.PROFILE_URL, currentUrl);
    }

    // Переход из личного кабинета в конструктор
    @Test
    public void navigateToConstructorFromUserAccountTest() {
        homePage.clickAccountButton();
        loginPage.setUserData(UserGenerator.email, UserGenerator.password);
        loginPage.clickLoginButton();
        homePage.clickAccountButton();
        profilePage.clickConstructorLink();
        homePage.checkCreateOrderButton();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(Constants.BASE_URL, currentUrl);
    }

    // Переход из личного кабинета в конструктор по клику на логотип
    @Test
    public void navigateToConstructorFromUserAccountByClickOnLogoTest() {
        homePage.clickAccountButton();
        loginPage.setUserData(UserGenerator.email, UserGenerator.password);
        loginPage.clickLoginButton();
        homePage.clickAccountButton();
        profilePage.clickStellarLogo();
        homePage.checkCreateOrderButton();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(Constants.BASE_URL, currentUrl);
    }

    // выход через кнопку «Выход»,
    @Test
    public void logoutFromAccountTest() {
        homePage.clickAccountButton();
        loginPage.setUserData(UserGenerator.email, UserGenerator.password);
        loginPage.clickLoginButton();
        homePage.clickAccountButton();
        profilePage.clickExitButton();
        loginPage.checkRecoveryPassButton();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(Constants.LOGIN_URL, currentUrl);
    }

    @After
    public void closeDriver() {
        closeWebDriver();
    }
}
