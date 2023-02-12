package pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
    //Локатор кнопки "Личный кабинет"
    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']")
    private SelenideElement accountButton;

    //Локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    private SelenideElement enterToAccountButton;

    //Локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private SelenideElement createOrder;

    //Локатор выбранного раздела (название)
    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span")
    private SelenideElement currentTab;

    //Локатор раздела булки
    @FindBy(how = How.XPATH, using = ".//main/section[1]/div/div[1]")
    private SelenideElement bunSwitcher;

    //Локатор раздела соусы
    @FindBy(how = How.XPATH, using = ".//main/section[1]/div/div[2]")
    private SelenideElement sauceSwitcher;

    //Локатор раздела начинки
    @FindBy(how = How.XPATH, using = ".//main/section[1]/div/div[3]")
    private SelenideElement toppingsSwitcher;

    public void clickAccountButton() {
        accountButton.click();
    }

    public void clickEnterToAccountButton() {
        enterToAccountButton.click();
    }

    public void checkCreateOrderButton() {
        createOrder.shouldBe(Condition.visible);
    }

    public String getCurrentTabText() {
        return currentTab.getText();
    }

    public void clickBun() {
        bunSwitcher.click();
    }

    public void clickSauce() {
        sauceSwitcher.click();
    }

    public void clickToppings() {
        toppingsSwitcher.click();
    }

}
