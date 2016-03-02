package com.dumitruc.appium;


import com.dumitruc.appium.support.MyProperties;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by dima on 13/12/2013.
 */
public class AppiumDriver implements WebDriver {

    private static Application runningApp;
    private static WebDriver driver;
    private static AppiumDriver instance = null;

    private Logger execLog = Logger.getLogger("Execution");
    private DesiredCapabilities capabilities;

    protected AppiumDriver() {
    }

    public static AppiumDriver getInstance() {
        if (instance == null) {
            instance = new AppiumDriver();
        }

        return instance;
    }

    public void startApplication(Application appName) throws Exception {

        runningApp = appName;

        //TODO Create a separate method to deal with resetting/reinstalling the app.
        //Until then, keep this clean with th assumption the app is already installed
        //capabilities.setCapability("app", app.getApkFullPath());

        capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", runningApp.getDesignatedDeviceType());
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(CapabilityType.VERSION, "4.4");
        capabilities.setCapability(CapabilityType.PLATFORM, "MAC");

        capabilities.setCapability("app-package", runningApp.getAppPackage());
        capabilities.setCapability("app-activity", runningApp.getAppActivity());

        instantiateWebDriver();
    }

    public void instantiateWebDriver() throws MalformedURLException {

        //TODO Do this only if it is a different app then the one running
        if (driver != null){
            quit();
        }

        driver = new SwipeableWebDriver(new URL(MyProperties.getProperty("appium.listener.url")), capabilities);
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);//Latest addition
        execLog.info("Appium driver successfully initiated");
    }

    public void tearDown() throws Exception {
        driver.quit();
    }

    public static void takeScreenShotToFile(String filePath) throws IOException {
        System.out.println("Taking screenshot");

        File screenshotFile = new File(filePath);

        try {
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            screenshotFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error capturing screen shot of " + screenshotFile.getAbsolutePath() + " test failure.");
        }

        System.out.println("Took Screenshot " + screenshotFile.getAbsolutePath());

    }

    public static byte[] baScreenShot() {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        return ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.BYTES);
    }

    //////////////////
    //Mobile actions//
    //////////////////

    public void swipeTo(WebElement element) {
        //TODO TO ADD DIRECTION
        //appiumWrapper.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //https://github.com/appium/appium/pull/1998/files#diff-0

        //WebElement element = driver.findElement(By.name("Log In"));


        HashMap<String, String> scrollToObject = new HashMap<String, String>();

        String elementId = ((RemoteWebElement) element).getId();

        scrollToObject.put("element",elementId);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("mobile: scrollTo", scrollToObject);

    }

    public void tapExact(Double xAxe, Double yAxe) {
        //to implement tap action
    }

    public void tapOnCenter(WebElement screenElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("x", (double) 0.9); // from 0 to 1 show percentages, 0.5 place its in center
        tapObject.put("y", (double) 0.3); // from 0 to 1 show percentages, 0.5 place its in middle
        tapObject.put("element", Double.parseDouble(((RemoteWebElement) screenElement).getId()));
        js.executeScript("mobile: tap", tapObject);
    }

    public void hideKeyboard() {

        //TODO: Not working, also need to consider different types of keyboards, including custom keyboards

        //String KEYBOARD_HIDE="UIATarget.localTarget().frontMostApp().keyboard().buttons()['Done'].tap();";
        String KEYBOARD_HIDE = "Done";
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("mobile: hideKeyboard", KEYBOARD_HIDE);
        //self.driver.execute_script('UIATarget.localTarget().frontMostApp().keyboard().buttons()["Done"].tap();');
    }

    public void swipe() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.5);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.05);
        swipeObject.put("endY", 0.05);
        swipeObject.put("duration", 1.8);
        js.executeScript("mobile: swipe", swipeObject);
    }

    @Override
    public void get(String s) {
        driver.get(s);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }

    public Application getRunningApp() {
        return runningApp;
    }

    public void setRunningApp(Application runningApp) {
        this.runningApp = runningApp;
    }
}
