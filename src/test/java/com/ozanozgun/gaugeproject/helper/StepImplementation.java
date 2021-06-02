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
       // log.info("Waiting 2 seconds...");
        TimeUnit.SECONDS.sleep(2);
    }

    @Step("Accept device location")
    public void acceptDeviceLocation() throws InterruptedException {
        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
       // log.info("Device location info accepted");
    }

    @Step("Accept privacy policy")
    public void acceptPrivayPolicy() throws InterruptedException {
        driver.findElement(By.id("com.turkishairlines.mobile:id/frPrivacy_btnAccept")).click();
    }

    @Step("Book a flight")
    public void bookAFlight() throws InterruptedException {
        driver.findElement(By.id("com.turkishairlines.mobile:id/acMain_btnBooking")).click();
    }

    @Step("Select one way")
    public void selectOneWay() throws InterruptedException {
        driver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_tvOneWay")).click();
    }

    @Step("Select from destination")
    public void selectFomDestination() throws InterruptedException {
        driver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_tvFromCode")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.turkishairlines.mobile:id/frAirportSelection_etSearch")).sendKeys("SAW");
        driver.findElement(By.xpath("//*[@text='SAW - Sabiha Gokcen Airport']")).click();


    }

    @Step("Select to destination")
    public void selectToDestination() throws InterruptedException {
        driver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_tvToCode")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.turkishairlines.mobile:id/frAirportSelection_etSearch")).sendKeys("ESB");
        driver.findElement(By.xpath("//*[@text='ESB - Ankara Esenboga Airport']")).click();
    }

    @Step("Set departure date")
    public void setDepartureDate() throws InterruptedException {
        String currentDate = driver.findElement(By.id("com.turkishairlines.mobile:id/dateWidget_tvDateDay")).getText().trim();
        driver.findElement(By.id("com.turkishairlines.mobile:id/dateWidget_tvDateDay")).click();
        int departureDate = Integer.parseInt(currentDate);
        departureDate += 2;
        driver.findElement(By.xpath("//*[@text=" + departureDate + "]")).click();
        driver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_btnDone")).click();
    }

    @Step("Set passenger number")
    public void setPassengerNumder() throws InterruptedException {
        driver.findElement(By.id("com.turkishairlines.mobile:id/cvPassengerItem_imPlus")).click();
    }

    @Step("Search flight")
    public void searchFlight() throws InterruptedException {
        driver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_btnSearch")).click();
    }

    @Step("Check is flights listed")
    public void checkListedFlights() throws InterruptedException {
        if (driver.findElements(By.id("com.turkishairlines.mobile:id/frFlightSearch_rvFlight")).size() > 0) {
            System.out.println("Flights are listed");
        } else {
            System.out.println("Flights are NOT listed!!");
        }
    }

    @Step("Select random flight on the screen")
    public void selectRandomFlightOnTheScreen() throws InterruptedException {
        List<WebElement> flightList = driver.findElements(By.id("com.turkishairlines.mobile:id/itemFlightSearchParent_clPrice"));
        Random r = new Random();
        int random = r.nextInt(flightList.size());
        flightList.get(random).click();
    }

    @Step("Select eco class")
    public void selectEcoClass() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'EcoFly')]")).click();

    }

    @Step("Click continue")
    public void clickContinue() throws InterruptedException {
        driver.findElement(By.id("com.turkishairlines.mobile:id/frFlightSearch_btnContinue")).click();
    }


}
