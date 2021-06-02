package com.ozanozgun.gaugeproject.helper;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class StepImplementation extends HookImplementation {

    private HashSet<Character> vowels;

    @Step("Wait 2 seconds")
    public void waitTwoSeconds() throws InterruptedException {
        log.info("Waiting 2 seconds...");
        TimeUnit.SECONDS.sleep(2);
    }

    @Step("Accept device location")
    public void acceptDeviceLocation() throws InterruptedException {
        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        log.info("Device location info accepted");
    }

    @Step("Accept privacy policy")
    public void acceptPrivayPolicy() throws InterruptedException {
        driver.findElement(By.id("com.turkishairlines.mobile:id/frPrivacy_btnAccept")).click();
        log.info("Privacy policy accepted");
    }

    @Step("Book a flight")
    public void bookAFlight() throws InterruptedException {
        driver.findElement(By.id("com.turkishairlines.mobile:id/acMain_btnBooking")).click();
        log.info("Book a flight button clicked");
    }

    @Step("Select one way")
    public void selectOneWay() throws InterruptedException {
        driver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_tvOneWay")).click();
        log.info("One way selected");
    }

    @Step("Select from destination")
    public void selectFomDestination() throws InterruptedException {
        driver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_tvFromCode")).click();
        log.info("From destination search area opened");
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.turkishairlines.mobile:id/frAirportSelection_etSearch")).sendKeys("SAW");
        log.info("SAW keyword entered to search area");
        driver.findElement(By.xpath("//*[@text='SAW - Sabiha Gokcen Airport']")).click();
        log.info("Sabiha Gokcen Airport selected");


    }

    @Step("Select to destination")
    public void selectToDestination() throws InterruptedException {
        driver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_tvToCode")).click();
        log.info("To destination search area opened");
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.turkishairlines.mobile:id/frAirportSelection_etSearch")).sendKeys("ESB");
        log.info("ESB keyword entered to search area");
        driver.findElement(By.xpath("//*[@text='ESB - Ankara Esenboga Airport']")).click();
        log.info("Ankara Esenboga Airport selected");
    }

    @Step("Set departure date")
    public void setDepartureDate() throws InterruptedException {
        String currentDate = driver.findElement(By.id("com.turkishairlines.mobile:id/dateWidget_tvDateDay")).getText().trim();
        driver.findElement(By.id("com.turkishairlines.mobile:id/dateWidget_tvDateDay")).click();
        log.info("Departure date calendar opened");
        int departureDate = Integer.parseInt(currentDate);
        departureDate += 2;
        driver.findElement(By.xpath("//*[@text=" + departureDate + "]")).click();
        log.info("Two days after selected");

    }

    @Step("Click done button on calendar screen")
    public void clickDoneBtnOnCalendar(){
        driver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_btnDone")).click();
        log.info("Departure calendar done button clicked");
    }

    @Step("Set passenger number")
    public void setPassengerNumder() throws InterruptedException {
        driver.findElement(By.id("com.turkishairlines.mobile:id/cvPassengerItem_imPlus")).click();
        log.info("Number of passenger is increased by 1");
    }

    @Step("Search flight")
    public void searchFlight() throws InterruptedException {
        driver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_btnSearch")).click();
        log.info("Flight search button is clicked");
    }

    @Step("Check is flights listed")
    public void checkListedFlights() throws InterruptedException {
        if (driver.findElements(By.id("com.turkishairlines.mobile:id/frFlightSearch_rvFlight")).size() > 0) {
            log.info("Flights are listed");
        } else {
            log.error("Flights are NOT listed!!");
        }
    }

    @Step("Select random flight on the screen")
    public void selectRandomFlightOnTheScreen() throws InterruptedException {
        List<WebElement> flightList = driver.findElements(By.id("com.turkishairlines.mobile:id/itemFlightSearchParent_clPrice"));
        Random r = new Random();
        int random = r.nextInt(flightList.size());
        flightList.get(random).click();
        log.info("Random flight is selected on the screen");
    }

    @Step("Select eco class")
    public void selectEcoClass() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'EcoFly')]")).click();
        log.info("Flight contains EcoFly is selected for selecting eco class");

    }

    @Step("Click continue")
    public void clickContinue() throws InterruptedException {
        driver.findElement(By.id("com.turkishairlines.mobile:id/frFlightSearch_btnContinue")).click();
        log.info("Continue button clicked on flight search");
    }


}
