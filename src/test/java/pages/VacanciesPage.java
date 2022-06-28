package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VacanciesPage extends BasePage {
    @FindBy(id = "menu-item-5079")
    private WebElement testAutomationVacancyItem;

    public VacanciesPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Goes to the Test Automation Engineer Vacancy page.
     */
    @Step("Go to the Test Automation Engineer Vacancy page")
    public void goToTestAutomationVacancyPage() {
        waitForVisibilityOf(testAutomationVacancyItem);
        testAutomationVacancyItem.click();
    }
}
