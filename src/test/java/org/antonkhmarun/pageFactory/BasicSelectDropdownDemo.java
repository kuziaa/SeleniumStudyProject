package org.antonkhmarun.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class BasicSelectDropdownDemo {

    public static final String CALIFORNIA= "California";
    public static final String FLORIDA = "Florida";
    public static final String NEW_JERSEY = "New Jersey";
    public static final String NEW_YORK = "New York";
    public static final String OHIO = "Ohio";
    public static final String TEXAS = "Texas";
    public static final String PENNSYLVANIA = "Pennsylvania";
    public static final String WASHINGTON = "Washington";

    public WebDriver driver;

    public BasicSelectDropdownDemo(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "select[multiple='multiple']")
    private WebElement multiSelectListWebElement;

    @FindBy(css = "button[value='Print All']")
    private WebElement getAllSelectedBtn;

    @FindBy(css = ".panel-body > .getall-selected")
    private WebElement allSelected;

    public Select getMultiSelectList() {
        return new Select(multiSelectListWebElement);
    }

    public void pushGetAllSelectedBtn() {
        getAllSelectedBtn.click();
    }

    public boolean isSelectedListEqualSelectedElements(List<String> selectedElements) {

        List<String> selectedElementsOnPage = getMultiSelectList().getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());

        return selectedElementsOnPage.containsAll(selectedElements) && selectedElements.containsAll(selectedElementsOnPage);
    }
}
