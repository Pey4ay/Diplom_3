package pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    //Локатор заголовока "Вход"
    @FindBy(how = How.XPATH, using = "//div[@class='Auth_login__3hAey']/h2")
    private SelenideElement loginPageTitle;

    //Локатор поля ввода почты
    @FindBy(how = How.XPATH, using = "//label[text()='Email']/following-sibling::input[@name='name']")
    private SelenideElement emailInput;

    //Локатор поля ввода пароля
    @FindBy(how = How.XPATH, using = "//input[@name='Пароль']")
    private SelenideElement passwordInput;

    //Локатор кнопки "Вход"
    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    private SelenideElement loginButton;

    //Локатор для перехода на страницу регистрации
    @FindBy(how = How.XPATH, using = "//a[text()='Зарегистрироваться']")
    private SelenideElement registrationPageLink;

    //Локатор кнопки "Восстановить пароль"
    @FindBy(how = How.XPATH, using = "//a[text()='Восстановить пароль']")
    private SelenideElement recoveryPassButton;

    public void setUserData(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void checkRecoveryPassButton() {
        recoveryPassButton.shouldBe(Condition.visible);
    }

    public void clickRegistrationPageLink() {
        registrationPageLink.click();
    }

    public void clickRecoveryPassButton(){
        recoveryPassButton.click();
    }
}
