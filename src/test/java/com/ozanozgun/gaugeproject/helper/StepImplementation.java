package com.ozanozgun.gaugeproject.helper;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.By;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class StepImplementation extends HookImplementation {

    private HashSet<Character> vowels;

    @Step("First Step")
    public void firstTest()throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();

    }
}
