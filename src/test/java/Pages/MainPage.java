package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static Utils.TestBase.getDriver;

public class MainPage {

    String HomePage_title = "Mars Airlines: Home";
    WebDriver driver;
    // Page elements
    public final By headerLocator = By.cssSelector("#app > h1 > a"),
            contentHeaderLocator = By.cssSelector("#content > h2"),
            contentDescriptionLocator = By.cssSelector("#content > form > h3"),
            departureLabelLocator = By.cssSelector("label[for='departing']"),
            arrivalLabelLocator = By.cssSelector("label[for='returning']"),
            departureDropDownLocator = By.cssSelector("#departing"),
            arrivalDropDownLocator = By.cssSelector("#returning"),
            promoCodeLabelLocator = By.cssSelector("label[for='promotional_code']"),
            promoCodeFieldLocator = By.cssSelector("#promotional_code"),
            searchButtonLocator = By.cssSelector("input[type='submit']"),
            contentBackLinkLocator = By.cssSelector("#content > p:nth-child(3) > a"),
            contentTextLocator = By.cssSelector("#content > p:nth-child(2)"),
            contentText2ndLineLocator = By.cssSelector("#content > p.promo_code"),
            contentText3rdLineLocator = By.cssSelector("#content > p:nth-child(4)");


    private String log_pageName = "[Login Page]", log_indicator = ">> ";

    public MainPage() {
        driver = getDriver();
    }

    public boolean isCurrent() {
        System.out.println(log_indicator + log_pageName + " Checking if page is current...");
        return driver.getTitle().equals(HomePage_title);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public Boolean isHeaderPresent() {
        return driver.findElements(headerLocator).size() > 0;
    }

    public String getHeaderText() {
        return driver.findElement(headerLocator).getText();
    }

    public String getTextForElement(String locator) {
        return driver.findElement(headerLocator).getText();
    }

    public String getTextForElement(By locator) {
        return driver.findElement(locator).getText();
    }

    public Boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() == 1;
    }

    public ArrayList<String> getDropDownOptionsFor(By locator) {
        ArrayList<String> dropDownOptions = new ArrayList<>();
        Select dropDown = new Select(driver.findElement(locator));
        List<WebElement> rawDropDownValues = dropDown.getOptions();
        for (int i = 0; i < rawDropDownValues.size(); i++) {
            dropDownOptions.add(rawDropDownValues.get(i).getText());
        }
        return dropDownOptions;
    }

    public void selectOptionInDropDown(By locator, String optionText) {
        Select dropDown = new Select(driver.findElement(locator));
        dropDown.selectByVisibleText(optionText);
    }

    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public String getHrefValueOf(By locator) {
        return driver.findElement(locator).getAttribute("href");
    }

    public void setTextFieldValueFor(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }


    public boolean isClickable(By locator) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(locator));

            return true;
        } catch (Exception e) {
            return false;
        }

    }


    public boolean isClickable1(By locator) {


        try {
            driver.findElement(By.linkText("Book a ticket to the red planet now!)"));

            return true;
        }catch  (Exception e){
            return false;
        }

    }
}
