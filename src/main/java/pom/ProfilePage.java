package pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {

    //Локатор конструктора
    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    private SelenideElement constructorLink;

    //Локатор лого стеллар
    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']/a")
    private SelenideElement stellarLogo;

    //Локатор имени
    @FindBy(how = How.XPATH, using = "//input[@name='Name']")
    private SelenideElement nameInput;

    //Локатор кнопки выход
    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    private SelenideElement logoutButton;

    public void checkIfInputVisible(){
        nameInput.shouldBe(Condition.visible);
    }

    public void clickConstructorLink(){
        constructorLink.click();
    }

    public void clickStellarLogo(){
        stellarLogo.click();
    }

    public void clickExitButton(){
        logoutButton.click();
    }
}
