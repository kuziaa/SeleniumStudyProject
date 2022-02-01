package org.antonkhmarun;

import org.antonkhmarun.config.ConfProperties;
import org.antonkhmarun.pages.BootstrapDownloadProgressDemo;
import org.antonkhmarun.pages.TableSortSearchDemo;
import org.antonkhmarun.pojo.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableSortSearchTest {

    TableSortSearchDemo tableSortSearchDemo;
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void downloadingTo50Percent() throws InterruptedException {
        tableSortSearchDemo = new TableSortSearchDemo(driver);
        driver.get(ConfProperties.getProperty("tableSortSearchDemo"));

        Select numOfEntries = tableSortSearchDemo.getNumOfEntriesSelect();
        numOfEntries.selectByVisibleText("10");

        List<WebElement> allEmployees = tableSortSearchDemo.getEmployeesFromAllPages();
        List<WebElement> sortedEmployees = tableSortSearchDemo.sortEmployees(allEmployees, 33, 250000);

        List<Employee> employees = tableSortSearchDemo.mapEmployees(sortedEmployees);

        System.out.println(employees);
        assertTrue(employees.size() > 0);

    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
