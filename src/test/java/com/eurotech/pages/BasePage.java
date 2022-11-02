package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    @FindBy(id = "rcc-confirm-button")
    public WebElement understandBtn;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
}
