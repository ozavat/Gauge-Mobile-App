package com.ozanozgun.gaugeproject.helper;

import com.thoughtworks.gauge.Step;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class MainPageImp extends HookImplementation {
    Logger log = org.apache.logging.log4j.LogManager.getLogger(this);


    @Step("Accept privacy policy at <Key>")
    public void acceptPrivayPolicy(String key) throws InterruptedException {
        String value= parser(key);
        driver.findElement(By.id(value)).click();
        log.info("Privacy policy accepted");
    }

    @Step("Book a flight with <key>")
    public void bookAFlight(String key) throws InterruptedException {
        String value= parser(key);
        driver.findElement(By.id(value)).click();
        log.info("Book a flight button clicked");
    }
}
