package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Home page of a web-site.
 */
public class HomePage extends BasePage {
    @FindBy(id = "menu-item-127")
    private WebElement careersMenuItem;

    @FindBy(id = "menu-item-131")
    private WebElement vacanciesMenuChildItem;

    private final By vacanciesMenuChildItemBy = By.id("menu-item-131");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Goes to the Vacancies page.
     */
    @Step("Go to the Vacancies page")
    public void goToVacanciesPage() {
        waitForVisibilityOf(careersMenuItem);
        while (!driver.findElements(vacanciesMenuChildItemBy).get(0).isDisplayed()) {
            hoverOver(careersMenuItem);
            careersMenuItem.click();
        }
        vacanciesMenuChildItem.click();
    }
}
