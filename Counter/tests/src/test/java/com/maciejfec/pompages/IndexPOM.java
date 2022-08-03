package com.maciejfec.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPOM {

    private WebDriver driver;

    public IndexPOM(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "increase")
    private WebElement increaseBtn;

    @FindBy(id = "decrease")
    private WebElement decreaseBtn;

    @FindBy(id = "reset")
    private WebElement resetBtn;
}
