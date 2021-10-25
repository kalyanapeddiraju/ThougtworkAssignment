package tests;

import Pages.MainPage;
import Utils.TestBase;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Main extends TestBase {

    static WebDriver driver = getDriver();
    MainPage mainPage = new MainPage();
    private final String pageUrl = "http://candidate3004ec1.marsair.tw/";
    private final String noMoreSeatsMessage = "Sorry, there are no more seats available.",
            scheduleNotPossibleMessage = "Unfortunately, this schedule is not possible. Please try again.";

    private final String seatsAvailableMessage = "Seats available!", promoTailMessage = "Call now on 0800 MARSAIR to book!";
    private String promoContentMessage = "";
    String promoCode, promoMessage, promoFailMessage;


    @Test
    public void validatePageContent() {
        if (!driver.getCurrentUrl().equals(pageUrl)) {
            driver.navigate().to(pageUrl);
        }
        assertEquals("Title of page is incorrect", "Mars Airlines: Home", mainPage.getPageTitle());
        assertTrue("Title of page is incorrect", mainPage.isHeaderPresent());
        assertEquals("Heading of page is incorrect", "MarsAir", mainPage.getHeaderText());

        // Check if departure label exists and is correct
        //assertTrue("Label for Departure drop down doesn't exist", mainPage.isElementPresent(mainPage.departureLabelLocator));
        assertEquals("Departure label is incorrect", "departure", mainPage.getTextForElement(mainPage.departureLabelLocator));
        assertEquals("Departure label is incorrect", "Departing", mainPage.getTextForElement(mainPage.departureLabelLocator));

        // Check if return label exists and is correct
        // assertTrue("Label for Return drop down doesn't exist", mainPage.isElementPresent(mainPage.arrivalLabelLocator));
        assertEquals("Return label is incorrect", "return", mainPage.getTextForElement(mainPage.arrivalLabelLocator));
        assertEquals("Return label is incorrect", "Returning", mainPage.getTextForElement(mainPage.arrivalLabelLocator));
    }


    @Test
    public void validateDropdownValues() {

        if (!driver.getCurrentUrl().equals(pageUrl)) {
            driver.navigate().to(pageUrl);
        }

        assertTrue("Departure drop down does not exist", mainPage.isElementPresent(mainPage.departureDropDownLocator));
        assertEquals("Drop down list values for Departure are incorrect.", getListOfExpectedDropDownValues(), mainPage.getDropDownOptionsFor(mainPage.departureDropDownLocator));

        assertTrue("Return drop down does not exist", mainPage.isElementPresent(mainPage.arrivalDropDownLocator));
        assertEquals("Drop down list values for Return are incorrect.", getListOfExpectedDropDownValues(), mainPage.getDropDownOptionsFor(mainPage.arrivalDropDownLocator));

    }


    @Test
    public void validateSearchFeature() {
        if (!driver.getCurrentUrl().equals(pageUrl)) {
            driver.navigate().to(pageUrl);
        }

        ArrayList<String> dropDownOptions = getListOfExpectedDropDownValues();

        // Verifying drop down elements
        assertTrue("Departure drop down does not exist", mainPage.isElementPresent(mainPage.departureDropDownLocator));
        assertEquals("Drop down list values for Departure are incorrect.", getListOfExpectedDropDownValues(), mainPage.getDropDownOptionsFor(mainPage.departureDropDownLocator));
        assertTrue("Return drop down does not exist", mainPage.isElementPresent(mainPage.arrivalDropDownLocator));
        assertEquals("Drop down list values for Return are incorrect.", getListOfExpectedDropDownValues(), mainPage.getDropDownOptionsFor(mainPage.arrivalDropDownLocator));
        assertTrue("Search button does not exist", mainPage.isElementPresent(mainPage.searchButtonLocator));

        int i = 1;
        int gap = 1;
        while (i + gap < dropDownOptions.size()) {
            String departOption = dropDownOptions.get(i), returnOption = dropDownOptions.get(i + gap);
            mainPage.selectOptionInDropDown(mainPage.departureDropDownLocator, departOption);
            mainPage.selectOptionInDropDown(mainPage.arrivalDropDownLocator, returnOption);
            mainPage.clickElement(mainPage.searchButtonLocator);
            assertEquals("Search results heading is incorrect", "Search Results", mainPage.getTextForElement(mainPage.contentHeaderLocator));
            System.out.println(">> Index:Gap: " + i + ":" + gap + " >> " + mainPage.getTextForElement(mainPage.contentTextLocator));
            assertEquals("Search results content message is incorrect", scheduleNotPossibleMessage, mainPage.getTextForElement(mainPage.contentTextLocator));
            assertTrue("Search content has no Back link", mainPage.isElementPresent(mainPage.contentBackLinkLocator));
            mainPage.clickElement(mainPage.contentBackLinkLocator);
            i++;
        }

        i = 1;
        gap = 2;
        while (i + gap < dropDownOptions.size()) {
            String departOption = dropDownOptions.get(i), returnOption = dropDownOptions.get(i + gap);
            mainPage.selectOptionInDropDown(mainPage.departureDropDownLocator, departOption);
            mainPage.selectOptionInDropDown(mainPage.arrivalDropDownLocator, returnOption);
            mainPage.clickElement(mainPage.searchButtonLocator);
            assertEquals("Search results heading is incorrect", "Search Results", mainPage.getTextForElement(mainPage.contentHeaderLocator));
            System.out.println(">> Index:Gap: " + i + ":" + gap + " >> " + mainPage.getTextForElement(mainPage.contentTextLocator));
            assertEquals("Search results content message is incorrect", noMoreSeatsMessage, mainPage.getTextForElement(mainPage.contentTextLocator));
            assertTrue("Search content has no Back link", mainPage.isElementPresent(mainPage.contentBackLinkLocator));
            mainPage.clickElement(mainPage.contentBackLinkLocator);
            i++;
        }

        i = 1;
        gap = 3;
        while (i + gap < dropDownOptions.size()) {
            String departOption = dropDownOptions.get(i), returnOption = dropDownOptions.get(i + gap);
            mainPage.selectOptionInDropDown(mainPage.departureDropDownLocator, departOption);
            mainPage.selectOptionInDropDown(mainPage.arrivalDropDownLocator, returnOption);
            mainPage.clickElement(mainPage.searchButtonLocator);
            assertEquals("Search results heading is incorrect", "Search Results", mainPage.getTextForElement(mainPage.contentHeaderLocator));
            System.out.println(">> Index:Gap: " + i + ":" + gap + " >> " + mainPage.getTextForElement(mainPage.contentTextLocator));
            assertEquals("Search results content message is incorrect", noMoreSeatsMessage, mainPage.getTextForElement(mainPage.contentTextLocator));
            assertTrue("Search content has no Back link", mainPage.isElementPresent(mainPage.contentBackLinkLocator));
            mainPage.clickElement(mainPage.contentBackLinkLocator);
            i++;
        }

        i = 1;
        gap = 4;
        while (i + gap < dropDownOptions.size()) {
            String departOption = dropDownOptions.get(i), returnOption = dropDownOptions.get(i + gap);
            mainPage.selectOptionInDropDown(mainPage.departureDropDownLocator, departOption);
            mainPage.selectOptionInDropDown(mainPage.arrivalDropDownLocator, returnOption);
            mainPage.clickElement(mainPage.searchButtonLocator);
            assertEquals("Search results heading is incorrect", "Search Results", mainPage.getTextForElement(mainPage.contentHeaderLocator));
            System.out.println(">> Index:Gap: " + i + ":" + gap + " >> " + mainPage.getTextForElement(mainPage.contentTextLocator));
            assertEquals("Search results content message is incorrect", noMoreSeatsMessage, mainPage.getTextForElement(mainPage.contentTextLocator));
            assertTrue("Search content has no Back link", mainPage.isElementPresent(mainPage.contentBackLinkLocator));
            mainPage.clickElement(mainPage.contentBackLinkLocator);
            i++;
        }
    }


    @Test
    public void validatePromoCodeAndBookSeats() {
        if (!driver.getCurrentUrl().equals(pageUrl)) {
            driver.navigate().to(pageUrl);
        }

        ArrayList<String> dropDownOptions = getListOfExpectedDropDownValues();

        mainPage.selectOptionInDropDown(mainPage.departureDropDownLocator, dropDownOptions.get(1));
        mainPage.selectOptionInDropDown(mainPage.arrivalDropDownLocator, dropDownOptions.get(dropDownOptions.size() - 1));

        promoCode = "AF3-FJK-418";
        promoMessage = "Promotional code codeString used: discountString% discount!";


        boolean promoCodeChk = isValid(promoCode);

        if (promoCodeChk) {

            int discountDigit = Integer.valueOf(promoCode.substring(2, 3));
            int total = discountDigit + Integer.valueOf(promoCode.substring(8, 9)) + Integer.valueOf(promoCode.substring(9, 10));
            int checkDigit = Integer.valueOf(promoCode.substring(10, 11)) % 10;
            assertEquals("Check digit is incorrect", promoCode.substring(promoCode.length() - 1), String.valueOf(checkDigit));
            promoContentMessage = promoMessage.replace("codeString", promoCode).replace("discountString", String.valueOf(discountDigit * 10));
            System.out.println("Promo message:" + promoContentMessage);
            mainPage.setTextFieldValueFor(mainPage.promoCodeFieldLocator, promoCode);
            mainPage.clickElement(mainPage.searchButtonLocator);

            assertEquals("Search results content message is incorrect", seatsAvailableMessage, mainPage.getTextForElement(mainPage.contentTextLocator));
            assertEquals("Search results content message is incorrect", promoContentMessage, mainPage.getTextForElement(mainPage.contentText2ndLineLocator));
            assertEquals("Search results content message is incorrect", promoTailMessage, mainPage.getTextForElement(mainPage.contentText3rdLineLocator));
        }

        mainPage.clickElement(mainPage.headerLocator);


    }


    @Test
    public void validateInvalidPromocode() throws InterruptedException {
        if (!driver.getCurrentUrl().equals(pageUrl)) {
            driver.navigate().to(pageUrl);
        }

        promoFailMessage = "Sorry, code codeString is not valid";
        ArrayList<String> dropDownOptions = getListOfExpectedDropDownValues();
        mainPage.selectOptionInDropDown(mainPage.departureDropDownLocator, dropDownOptions.get(1));
        mainPage.selectOptionInDropDown(mainPage.arrivalDropDownLocator, dropDownOptions.get(dropDownOptions.size() - 1));
        promoCode = "AF3-FJK-417";
        promoContentMessage = promoFailMessage.replaceAll("codeString", promoCode);
        System.out.println("Promo message:" + promoContentMessage);

        boolean promoCodeChk = isValid(promoCode);

        if (promoCodeChk) {

            mainPage.setTextFieldValueFor(mainPage.promoCodeFieldLocator, promoCode);
            mainPage.clickElement(mainPage.searchButtonLocator);
            assertEquals("Search results content message is incorrect", seatsAvailableMessage, mainPage.getTextForElement(mainPage.contentTextLocator));
            assertEquals("Search results content message is incorrect", promoContentMessage, mainPage.getTextForElement(mainPage.contentText2ndLineLocator));
            assertEquals("Search results content message is incorrect", promoTailMessage, mainPage.getTextForElement(mainPage.contentText3rdLineLocator));
        }
        mainPage.clickElement(mainPage.headerLocator);

    }


    @Test
    public void validateLogoFeature() {
        if (!driver.getCurrentUrl().equals(pageUrl)) {
            driver.navigate().to(pageUrl);
        }


        assertTrue("Book a ticket to the red planet now! is not a clicakble Link", mainPage.isClickable1(mainPage.contentDescriptionLocator));
        assertTrue("Logo / Header does not exist", mainPage.isElementPresent(mainPage.headerLocator));
        mainPage.clickElement(mainPage.headerLocator);
        assertEquals("Page did not redirect to main page", pageUrl, driver.getCurrentUrl());
        assertTrue("Content header does not exist", mainPage.isElementPresent(mainPage.contentHeaderLocator));
        assertEquals("Content header is incorrect", "Welcome to MarsAir!", mainPage.getTextForElement(mainPage.contentHeaderLocator));

    }


    @AfterClass
    public static void teardown() {
        driver.close();
    }

    private ArrayList<String> getListOfExpectedDropDownValues() {
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Select..."); //0
        expectedList.add("July");
        expectedList.add("December");
        expectedList.add("July (next year)");
        expectedList.add("December (next year)");
        expectedList.add("July (two years from now)");
        expectedList.add("December (two years from now)");
        return expectedList;
    }


    private boolean isValid(String s) {
        String pattern = "[a-zA-Z0-9]{3}-[A-ZA-ZA-Z]{3}-[0-90-90-9]{3}";
        return s.matches(pattern);
    }

}