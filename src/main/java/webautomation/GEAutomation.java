package webautomation;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GEAutomation {

    private static final String URL =
            "https://ge.globo.com/futebol/copa-do-mundo/";

    private WebDriver driver;
    private WebDriverWait wait;

    public void runTest() {

        try {
            setUpBrowser();
            openWebsite();
            validatePageTitle();
            validateCurrentURL();
            scrollPage();
            verifyKeywordPresence();
            countLinks();
            countImages();
            listHeadings();
            verifyButtonPresence();
        }
        catch (TimeoutException e) {
            System.out.println(
                    "The configured loading time has been exceeded.");
        }
        catch (NoSuchElementException e) {
            System.out.println(
                    "Keyword not found.");
        }
        catch (Exception e) {
            System.out.println(
                    "Unexpected error: " + e.getMessage());
        }
        finally {
            tearDownBrowser();
        }
    }

    private void setUpBrowser() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\BrowserDrivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void openWebsite() {
        driver.get(URL);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        System.out.println("Website loaded successfully.\n");
    }

    private void validatePageTitle() {
        System.out.println("Título: COPA DO MUNDO FIFA");

        System.out.println(driver.getTitle());

        System.out.println("Title successfully validated.");
    }

    private void validateCurrentURL() {
        if (Objects.requireNonNull(driver.getCurrentUrl())
                .contains("copa-do-mundo")) {

            System.out.println("This URL is valid.\n");
        } else {
            System.out.println("This URL is invalid.\n");
        }
    }

    private void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        System.out.println("Page scrolled successfully.\n");
    }

    private void verifyKeywordPresence() {
        String text = driver.findElement(By.tagName("body")).getText();

        if (text.contains("Brasil")) {
            System.out.println("Word \"" + "Brasil" + "\" found.\n");
        } else {
            System.out.println("Keyword not found.\n");
        }
    }

    private void countLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println("Number of links: " + links.size());
    }

    private void countImages() {
        List<WebElement> images = driver.findElements(By.tagName("img"));

        System.out.println("Number of images: " + images.size());
    }

    private void listHeadings() {
        List<WebElement> titles = driver.findElements(By.tagName("h2"));

        System.out.println("===== TITLES =====");

        for (WebElement titulo : titles) {
            if (!titulo.getText().isBlank()) {
                System.out.println(titulo.getText());
                System.out.println("--------------------------------------------------------");
            }
        }
        System.out.println();
    }

    private void verifyButtonPresence() {
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("Buttons found: " + buttons.size());

        System.out.println();
    }

    private void tearDownBrowser() {
        if (driver != null) {
            driver.quit();
            System.out.println("The browser has been closed.\n");
        }
    }
}