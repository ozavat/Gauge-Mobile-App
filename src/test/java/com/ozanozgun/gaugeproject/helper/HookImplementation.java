package com.ozanozgun.gaugeproject.helper;

import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
public class HookImplementation {

    public static AppiumDriver driver;

    Logger log = org.apache.logging.log4j.LogManager.getLogger(HookImplementation.class);
    JSONParser parser = new JSONParser();

   public String parser(String key){
       try {
           ClassLoader classLoader = getClass().getClassLoader();
           File file = new File(classLoader.getResource("MainPage.json").getFile());
           JSONArray obj = (JSONArray)parser.parse(new FileReader(file.getAbsolutePath()));

           for (Object o : obj) {
                JSONObject myKeys = (JSONObject) o;
               if (key.equals(myKeys.get("key"))){
                   return myKeys.get("value").toString();
               };
           }
       }catch (Exception e) {
           log.error(e);
       }
      return null;

   };

    @BeforeScenario
    public void prepareAndroidForAppium() throws MalformedURLException {
        log.info("Preparing connection");
        WebDriverWait wait;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Nexus_5x_API_27");
        capabilities.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("skipUnlock", "true");
        capabilities.setCapability("appPackage", "com.turkishairlines.mobile");
        capabilities.setCapability("appActivity", "com.turkishairlines.mobile.ui.main.MainActivity");
        capabilities.setCapability("noReset", "false");
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AppiumDriver(url, capabilities);
        log.info("Android device connected");
        wait = new WebDriverWait(driver, 10);


    }

    /*@Test
    public void basicTest () throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();

        System.out.println("test");

    }*/

}
