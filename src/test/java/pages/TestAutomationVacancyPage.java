package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TestAutomationVacancyPage extends BasePage {

    @FindAll({@FindBy(css = ".active > div > div > ul:nth-child(3) > li")})
    private List<WebElement> professionalSkillItems;

    public TestAutomationVacancyPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Returns the skills count.
     */
    @Step("Return the skills count")
    public int returnSkillsCount() {
        waitForVisibilityOf(professionalSkillItems.get(0));
        return professionalSkillItems.size();
    }
}
