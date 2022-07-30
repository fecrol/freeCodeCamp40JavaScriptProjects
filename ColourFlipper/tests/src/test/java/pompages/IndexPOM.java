package pompages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class IndexPOM {

    private WebDriver driver;

    public IndexPOM(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = ".colour")
    private List<WebElement> colours;

    @FindBy(id = "apply-btn")
    private WebElement applyBtn;

    @FindBy(tagName = "body")
    private WebElement body;

    public WebElement findElementByColour(String colour) {
        /*
        Finds the desired colour selector by colour to be used in other methods.
         */

        for(WebElement col : colours) {

            String colourId = col.getAttribute("id").substring(0, col.getAttribute("id").indexOf("-"));

            if(colourId.equals(colour.toLowerCase())) {
                return col;
            }
        }

        return null;
    }

    public void selectElement(WebElement element) {

        element.click();
    }

    public String getElementBgColour(WebElement element) {

        return element.getCssValue("background-color");
    }

    public boolean elementIsSelected(WebElement element) {
        /*
        Checks is a colour has been selected to be used in assertions.
         */

        boolean selected = false;

        String[] classList = element.getAttribute("class").split(" ");

        if(Arrays.asList(classList).contains("selected")) {
            selected = true;
        }

        return selected;
    }

    public String getBodyBgColour() {

        return body.getCssValue("background-color");
    }

    public void clickApplyBtn() {

        applyBtn.click();
    }

    public void applyBgColourWithEnterKey() {

        body.sendKeys(Keys.ENTER);
    }
}
