package pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    //Локатор поля ввода имени
    @FindBy(how = How.XPATH, using = "//label[text()='Имя']/following-sibling::input[@name='name']")
    private SelenideElement nameInput;

    //Локатор поля ввода почты
    @FindBy(how = How.XPATH, using = "//label[text()='Email']/following-sibling::input[@name='name']")
    private SelenideElement emailInput;

    //Локатор поля ввода пароля
    @FindBy(how = How.XPATH, using = "//input[@name='Пароль']")
    private SelenideElement passwordInput;

    //Локатор ккнопки "Зарегистрироваться"
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement registrationButton;

    //Локатор для перехода на страницу входа
    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    private SelenideElement loginPageLink;

    //Локатор сообщения об ошибке для пароля
    @FindBy(how = How.CLASS_NAME, using = "input__error")
    private SelenideElement passwordErrorMsg;

    public void setUserData(String name, String email, String password) {
        nameInput.setValue(name);
        emailInput.setValue(email);
        passwordInput.setValue(password);
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }

    public void checkPasswordErrorMsgDisplayed() {
        passwordErrorMsg.shouldHave(Condition.exactText("Некорректный пароль"));
    }

    public void clickLoginPageLink() {
        loginPageLink.click();
    }
}
