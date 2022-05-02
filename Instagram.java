package action;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Instagram {
    public static void main(String[] args) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "Galaxy A03s");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("udid", "R9ZT100NEDP");
            capabilities.setCapability("platformVersion", "11");
            // capabilities.setCapability("app","/home/mahenderlokhande/Downloads/ApiDemos-debug.apk");
            capabilities.setCapability("appPackage", "com.instagram.android");
            Thread.sleep(3000);
            capabilities.setCapability("appActivity", "com.instagram.mainactivity.LauncherActivity");
            Thread.sleep(8000);

            URL url = new URL("http://127.0.0.1:4724/wd/hub");
            AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, capabilities);
            //driver.manage().impli.pageLoadTimeout(8000, TimeUnit.MILLISECONDS);
            driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
           // driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Already have an account? Log in.\"]")).click();
           MobileElement element1= driver.findElement(By.id("com.instagram.android:id/log_in_button"));
           element1.click();
            System.out.println(element1.getText());
            MobileElement email=driver.findElement(By.id("com.instagram.android:id/login_username"));
            email.sendKeys("lokhandemahender2000@gmail.com");
            Thread.sleep(2000);
            MobileElement password=driver.findElement(By.id("com.instagram.android:id/password"));
            password.sendKeys("Lokhande@985");
            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(Long.parseLong("8000"),TimeUnit.MILLISECONDS);
            driver.findElement(By.id("com.instagram.android:id/button_text")).click();
            driver.manage().timeouts().implicitlyWait(7000,TimeUnit.MILLISECONDS);
            MobileElement profilelogin=driver.findElement(By.id("com.instagram.android:id/tab_avatar"));

            TouchActions action = new TouchActions(driver);
            Thread.sleep(3000);
            action.singleTap(profilelogin);
            action.perform();


            profilelogin.click();
            Thread.sleep(2000);


            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}