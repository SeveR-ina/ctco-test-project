package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.TestAutomationVacancyPage;
import pages.VacanciesPage;

public class VacancyPageTests extends BasicTest {

    private VacanciesPage vacanciesPage;

    /**
     * Sets and loads test properties.
     */
    @BeforeTest
    public void doBeforeTest() {
        initializeProperties();
        loadPropertiesFromFile();
    }

    /**
     * Opens Browser, goes to start URL, accepts cookies, asserts that start page is not null.
     * Opens Home page and closes all pop-ups.
     *
     * @param browser  can be chosen via parameter and value from testng xml.
     * @param headless can be chosen via parameter and value from testng xml.
     */
    @Parameters({"browser", "headless"})
    @BeforeMethod
    public void doBeforeMethod(String browser, boolean headless) {

        //All activities with drivers:
        doPreparationsFor(browser, headless);

        //Open Home Page:
        HomePage homePage = new HomePage(driver);

        //Go to Vacancies Page:
        homePage.goToVacanciesPage();

        vacanciesPage = new VacanciesPage(driver);
    }

    @AfterMethod
    public void closeBrowser() {
        quitDriver();
    }

    @Test(description = "Verify that paragraph under Professional skills and qualification: contains exactly 5 skills")
    @Severity(SeverityLevel.NORMAL)
    @Story("Story : Verify that paragraph under Professional skills and qualification: contains exactly 5 skills")
    public void checkAutoQASkills() {

        vacanciesPage.goToTestAutomationVacancyPage();

        TestAutomationVacancyPage testAutomationVacancyPage = new TestAutomationVacancyPage(driver);

        int actualAutoQASkills = testAutomationVacancyPage.returnSkillsCount();
        int expectedAutoQASkills = Integer.parseInt(testProperties.getProperty("expectedAutoQaSkills"));

        //Expects 5 skills for Test Auto Engineer, but there are 8 of them on the page
        Assert.assertEquals(actualAutoQASkills, expectedAutoQASkills,
                actualAutoQASkills + " skills don't equal "
                        + expectedAutoQASkills + " skills");
    }
}
