package fetch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FetchCodingExerciseSDET {
    public static void main(String[] args) {

    }
    private WebDriver driver;

    public FetchCodingExerciseSDET() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Niharika\\Downloads\\chromedriver-win64");
        driver = new ChromeDriver();
    }

    public void navigateToPage() {
        driver.get("https://www.example.com");
    }

    public void clickFakeBarButton(String fakeBar) {
        WebElement fakeBarButton = driver.findElement(By.id(fakeBar));
        fakeBarButton.click();
    }

    public void handleAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fakeBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fakebox")));
        String fakeGroup = fakeBox.getText();
        String fakeBar;

        if (fakeGroup.contains("baz")) {
            fakeBar = fakeGroup.split("baz")[1];
        } else {
            fakeBar = fakeGroup.split("bar")[1];
        }

        clickFakeBarButton(fakeBar);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
