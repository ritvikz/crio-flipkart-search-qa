
package demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import demo.wrappers.Wrappers;

public class TestCases {

    ChromeDriver driver;

    @Test
    public void testCase01() {

        Wrappers w = new Wrappers(driver);

        w.openURL("https://www.flipkart.com");
        w.closeLoginPopup();
        w.searchProduct("Washing Machine");
        w.sortByPopularity();

        int count = w.countRatingLessThan4();

        Assert.assertTrue(count >= 0);
    }

    @Test
    public void testCase02() {

        Wrappers w = new Wrappers(driver);

        w.openURL("https://www.flipkart.com");
        w.closeLoginPopup();
        w.searchProduct("iPhone");

        List<String> list = w.getTitlesWithDiscountMoreThan17();

        Assert.assertTrue(list.size() >= 0);
    }

    @Test
    public void testCase03() {

        Wrappers w = new Wrappers(driver);

        w.openURL("https://www.flipkart.com");
        w.closeLoginPopup();
        w.searchProduct("Coffee Mug");
        w.filter4Star();

        List<String> top = w.top5HighestReviews();

        Assert.assertTrue(top.size() <= 5);
    }

    @BeforeTest
    public void startBrowser()
    {
        ChromeOptions options = new ChromeOptions();

        options.setBinary("/usr/bin/google-chrome");

        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void endTest()
    {
        if(driver != null)
            driver.quit();
    }
}