//package org.antonkhmarun.test;
//
//import org.antonkhmarun.config.ConfProperties;
//import org.antonkhmarun.pageFactory.TableSortSearchDemo;
//import org.antonkhmarun.pojo.Employee;
//import org.junit.jupiter.api.*;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class TableSortSearchTest extends BaseTest {
//
//    TableSortSearchDemo tableSortSearchDemo;
//
//    @Test
//    public void moreThenOneEmployeeByCondition() {
//        tableSortSearchDemo = new TableSortSearchDemo(driver);
//        driver.get(ConfProperties.getProperty("tableSortSearchDemo"));
//
//        Select numOfEntries = tableSortSearchDemo.getNumOfEntriesSelect();
//        numOfEntries.selectByVisibleText("10");
//
//        List<Employee> employees = new ArrayList<>();
//
//        boolean isFirstPage = true;
//        do {
//            tableSortSearchDemo.clickNextBtnIfNotFirstPage(isFirstPage);
//            isFirstPage = false;
//
//            List<WebElement> filteredEmployeesFromPage = tableSortSearchDemo.getEmployeesFromPageByCondition(33, 250000);
//            employees.addAll(tableSortSearchDemo.mapEmployees(filteredEmployeesFromPage));
//        } while (tableSortSearchDemo.isNextBtnClickable());
//
//        assertTrue(employees.size() > 0);
//
//    }
//}
