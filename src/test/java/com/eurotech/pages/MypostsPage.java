package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MypostsPage extends BasePage {
    @FindBy(id = "post-form-title")
    public WebElement title;
    @FindBy(id = "post-form-textarea")
    public WebElement post;
    @FindBy(id = "post-form-btn")
    public WebElement submitBtn;

}
