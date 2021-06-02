package com.ozanozgun.gaugeproject.helper;

import com.thoughtworks.gauge.Step;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class FlightSearchImp extends HookImplementation {

    Logger log = org.apache.logging.log4j.LogManager.getLogger(this);
    @Step("Check is flights listed from <key>")
    public void checkListedFlights(String key) throws InterruptedException {
        String value= parser(key);
        if (driver.findElements(By.id(value)).size() > 0) {
            log.info("Flights are listed");
        } else {
            log.error("Flights are NOT listed!!");
        }
    }

    @Step("Select random flight on the screen with <list>")
    public void selectRandomFlightOnTheScreen(String key) throws InterruptedException {
        String value= parser(key);
        List<WebElement> flightList = driver.findElements(By.id(value));
        Random r = new Random();
        int random = r.nextInt(flightList.size());
        flightList.get(random).click();
        log.info("Random flight is selected on the screen");
    }

    @Step("Select eco class includes <key> text")
    public void selectEcoClass(String key) throws InterruptedException {
        String value= parser(key);
        driver.findElement(By.xpath(value)).click();
        log.info("Flight contains EcoFly is selected for selecting eco class");

    }

    @Step("Click continue <key>")
    public void clickContinue(String key) throws InterruptedException {
        String value= parser(key);
        driver.findElement(By.id(value)).click();
        log.info("Continue button clicked on flight search");
    }

}
