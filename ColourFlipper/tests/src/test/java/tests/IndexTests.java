package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pompages.IndexPOM;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IndexTests {

    private WebDriver driver;
    private IndexPOM indexPage;
    private String baseUrl = "https://fecrol.github.io/freeCodeCamp40JavaScriptProjects/ColourFlipper/";

    @BeforeEach
    public void setUp() {

        String browser = System.getProperty("browser");

        if(browser == null) {
            browser = "";
        }

        switch(browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver();
                driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

        indexPage = new IndexPOM(driver);

        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterEach
    public void teardown() {

        driver.quit();
    }

    @Test
    @DisplayName("Is able to apply background colour using apply button")
    public void applyBackgroundColourWithBtn() {

        WebElement colourSelector = indexPage.findElementByColour("red");
        indexPage.selectElement(colourSelector);

        boolean elementIsSelected = indexPage.elementIsSelected(colourSelector);
        assertThat("Element was not selected", elementIsSelected, is(true));

        indexPage.clickApplyBtn();

        String selectedElementBgColour = indexPage.getElementBgColour(colourSelector);
        String bodyBgColour = indexPage.getBodyBgColour();

        assertThat("Colours do not match", bodyBgColour.equals(selectedElementBgColour));
    }

    @Test
    @DisplayName("Is able to apply background colour using the Enter key")
    public void applyBackgroundColourWithEnterKey() {

        WebElement colourSelector = indexPage.findElementByColour("pink");
        indexPage.selectElement(colourSelector);

        boolean elementIsSelected = indexPage.elementIsSelected(colourSelector);
        assertThat("Element was not selected", elementIsSelected, is(true));

        indexPage.applyBgColourWithEnterKey();

        String selectedElementBgColour = indexPage.getElementBgColour(colourSelector);
        String bodyBgColour = indexPage.getBodyBgColour();

        assertThat("Colours do not match", bodyBgColour.equals(selectedElementBgColour));
    }
}
