package org.antonkhmarun.test;

import org.antonkhmarun.config.ConfProperties;
import org.antonkhmarun.pageFactory.BasicSelectDropdownDemo;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MultiSelectTest extends BaseTest {

    BasicSelectDropdownDemo basicSelectDropdownDemo;

    @Test
    public void multiSelectTest() {

        basicSelectDropdownDemo = new BasicSelectDropdownDemo(driver);
        driver.get(ConfProperties.getProperty("basicSelectDropdownDemo"));
        Select multiSelect = basicSelectDropdownDemo.getMultiSelectList();

        List<WebElement> selectedElementsInTheBeginning = multiSelect.getAllSelectedOptions();
        assertEquals(selectedElementsInTheBeginning.size(), 0, "No selected elements at first");

        List<String> elementsToSelect = List.of(BasicSelectDropdownDemo.NEW_JERSEY, BasicSelectDropdownDemo.TEXAS, BasicSelectDropdownDemo.CALIFORNIA);
        elementsToSelect.forEach(multiSelect::selectByVisibleText);

        basicSelectDropdownDemo.pushGetAllSelectedBtn();

        assertTrue(basicSelectDropdownDemo.isSelectedListEqualSelectedElements(elementsToSelect),
                "Elements which were chosen equals with finally selected on the page");
    }
}
