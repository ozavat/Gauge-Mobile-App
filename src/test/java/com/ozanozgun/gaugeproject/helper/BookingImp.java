package com.ozanozgun.gaugeproject.helper;

import com.thoughtworks.gauge.Step;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class BookingImp extends HookImplementation {

    Logger log = org.apache.logging.log4j.LogManager.getLogger(this);

    @Step("Select one way <key>")
    public void selectOneWay(String key) throws InterruptedException {
        String value= parser(key);
        driver.findElement(By.id(value)).click();
        log.info("One way selected");
    }

    @Step("Select <key> from destination, Enter <key> search area, Select <key> airport")
    public void selectFomDestination(String keyDest, String keyArea, String keyText) throws InterruptedException {
        String dest= parser(keyDest);
        driver.findElement(By.id(dest)).click();
        log.info("From destination search area opened");
        TimeUnit.SECONDS.sleep(2);
        String area= parser(keyArea);
        driver.findElement(By.id(area)).sendKeys("SAW");
        log.info("SAW keyword entered to search area");
        String text= parser(keyText);
        driver.findElement(By.xpath(text)).click();
        log.info("Sabiha Gokcen Airport selected");


    }

    @Step("Select <key> to destination, Enter <key> search area, Select <key> airport")
    public void selectToDestination(String keyDest, String keyArea, String keyText) throws InterruptedException {
        String dest= parser(keyDest);
        driver.findElement(By.id(dest)).click();
        log.info("To destination search area opened");
        TimeUnit.SECONDS.sleep(2);
        String area= parser(keyArea);
        driver.findElement(By.id(area)).sendKeys("ESB");
        log.info("ESB keyword entered to search area");
        String text= parser(keyText);
        driver.findElement(By.xpath(text)).click();
        log.info("Ankara Esenboga Airport selected");
    }

    @Step("Set departure date from <key>")
    public void setDepartureDate(String keyCurent) throws InterruptedException {
        String value= parser(keyCurent);
        String currentDate = driver.findElement(By.id(value)).getText().trim();
        driver.findElement(By.id(value)).click();
        log.info("Departure date calendar opened");
        int departureDate = Integer.parseInt(currentDate);
        departureDate += 2;
        driver.findElement(By.xpath("//*[@text=" + departureDate + "]")).click();
        log.info("Two days after selected");

    }

    @Step("Click done <key> on calendar screen")
    public void clickDoneBtnOnCalendar(String key) {
        String value= parser(key);
        driver.findElement(By.id(value)).click();
        log.info("Departure calendar done button clicked");
    }

    @Step("Increase passanger number with <key> button")
    public void setPassengerNumder(String key) throws InterruptedException {
        String value= parser(key);
        driver.findElement(By.id(value)).click();
        log.info("Number of passenger is increased by 1");
    }

    @Step("Click search flight <key>")
    public void searchFlight(String key) throws InterruptedException {
        String value= parser(key);
        driver.findElement(By.id(value)).click();
        log.info("Flight search button is clicked");
    }
}
