package org.antonkhmarun.pages;

import org.antonkhmarun.pojo.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class TableSortSearchDemo {

    public WebDriver driver;

    public TableSortSearchDemo(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "select[name='example_length']")
    private WebElement numOfEntriesOnPage;

    @FindBy(css = "tbody > [role='row']")
    private List<WebElement> employeesFromPage;

    @FindBy(css = ".next")
    private WebElement nextBtn;

    public Select getNumOfEntriesSelect() {
        return new Select(numOfEntriesOnPage);
    }

    public void clickNextBtn() {
        nextBtn.click();
    }

    public void clickNextBtnIfNotFirstPage(boolean isFirstPage) {
        if (!isFirstPage) {
            nextBtn.click();
        }
    }

    private int getAge(WebElement employee) {
        String ageStr = employee.findElement(By.cssSelector(":nth-child(4)")).getText();
        return Integer.parseInt(ageStr);
    }

    private int getSalary(WebElement employee) {
        String salaryStr = employee.findElement(By.cssSelector(":nth-child(6)")).getText();
        salaryStr = salaryStr
                .replace("$", "")
                .replace(",", "")
                .replace("/", "")
                .replace("y", "");
        return Integer.parseInt(salaryStr);
    }

    private String getName(WebElement employee) {
        return employee.findElement(By.cssSelector(":nth-child(1)")).getText();
    }

    private String getPosition(WebElement employee) {
        return employee.findElement(By.cssSelector(":nth-child(2)")).getText();
    }

    private String getOffice(WebElement employee) {
        return employee.findElement(By.cssSelector(":nth-child(3)")).getText();
    }

    public List<WebElement> getEmployeesFromPage() {
        return employeesFromPage;
    }

    public List<WebElement> getEmployeesFromPageByCondition(int ageGreaterThan, int salaryLessOrEqualTo) {
        return getEmployeesFromPage().stream().filter(
                employee -> getAge(employee) > ageGreaterThan && getSalary(employee) <= salaryLessOrEqualTo)
                .collect(Collectors.toList());
    }

    public boolean isNextBtnClickable() {
        String classCondition = nextBtn.getAttribute("class");
        return !classCondition.contains("disabled");
    }

    private Employee mapEmployee(WebElement employee) {
        Employee newEmployee = new Employee();

        newEmployee.setName(getName(employee));
        newEmployee.setPosition(getPosition(employee));
        newEmployee.setOffice(getOffice(employee));

        return newEmployee;
    }

    public List<Employee> mapEmployees(List<WebElement> employees) {
        return employees.stream().map(this::mapEmployee).collect(Collectors.toList());
    }
}
