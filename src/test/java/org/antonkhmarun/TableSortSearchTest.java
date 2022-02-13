package org.antonkhmarun;

import org.antonkhmarun.config.ConfProperties;
import org.antonkhmarun.pageFactory.TableSortSearchDemo;
import org.antonkhmarun.pojo.Employee;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    public void moreThenOneEmployeeByCondition() {
        tableSortSearchDemo = new TableSortSearchDemo(driver);
        driver.get(ConfProperties.getProperty("tableSortSearchDemo"));

        Select numOfEntries = tableSortSearchDemo.getNumOfEntriesSelect();
        numOfEntries.selectByVisibleText("10");

        List<Employee> employees = new ArrayList<>();

        boolean isFirstPage = true;
        do {
            tableSortSearchDemo.clickNextBtnIfNotFirstPage(isFirstPage);
            isFirstPage = false;

            List<WebElement> filteredEmployeesFromPage = tableSortSearchDemo.getEmployeesFromPageByCondition(33, 250000);
            employees.addAll(tableSortSearchDemo.mapEmployees(filteredEmployeesFromPage));
        } while (tableSortSearchDemo.isNextBtnClickable());

        assertTrue(employees.size() > 0);

    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
