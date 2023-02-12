package pom;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordRestorePage {

    //Локатор для перехода на страницу входа
    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    private SelenideElement loginPageLink;

    public void clickLoginPageLink(){
        loginPageLink.click();
    }
}
