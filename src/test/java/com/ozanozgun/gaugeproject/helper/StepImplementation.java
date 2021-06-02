package com.ozanozgun.gaugeproject.helper;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class StepImplementation extends HookImplementation {

    Logger log = org.apache.logging.log4j.LogManager.getLogger(this);


    @Step("Wait 2 seconds")
    public void waitTwoSeconds() throws InterruptedException {
        log.info("Waiting 2 seconds...");
        TimeUnit.SECONDS.sleep(2);
    }


    @Step("Accept device location at <key>")
    public void acceptDeviceLocation(String key) throws InterruptedException {
        String value= parser(key);
        driver.findElement(By.id(value)).click();
        log.info("Device location info accepted");
    }

}
