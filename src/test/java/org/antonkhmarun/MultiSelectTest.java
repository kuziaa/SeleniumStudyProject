package org.antonkhmarun;

import org.antonkhmarun.config.ConfProperties;
import org.antonkhmarun.pageFactory.BasicSelectDropdownDemo;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MultiSelectTest {

    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void multiSelectTest() {

        BasicSelectDropdownDemo basicSelectDropdownDemo = new BasicSelectDropdownDemo(driver);
        driver.get(ConfProperties.getProperty("basicSelectDropdownDemoPage"));
        Select multiSelect = basicSelectDropdownDemo.getMultiSelectList();

        List<WebElement> selectedElementsInTheBeginning = multiSelect.getAllSelectedOptions();
        assertEquals(selectedElementsInTheBeginning.size(), 0, "No selected elements at first");

        List<String> elementsToSelect = List.of(BasicSelectDropdownDemo.NEW_JERSEY, BasicSelectDropdownDemo.TEXAS, BasicSelectDropdownDemo.CALIFORNIA);
        elementsToSelect.forEach(multiSelect::selectByVisibleText);

        basicSelectDropdownDemo.pushGetAllSelectedBtn();

        assertTrue(basicSelectDropdownDemo.isSelectedListEqualSelectedElements(elementsToSelect),
                "Elements which were chosen equals with finally selected on the page");
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

}
