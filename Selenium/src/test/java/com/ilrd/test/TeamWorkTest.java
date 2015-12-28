package com.ilrd.test;

import com.ilrd.pages.teamwork.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by student on 23/12/15.
 */
@Test
@ContextConfiguration(locations = "classpath:seleniumContext.xml")
public class TeamWorkTest extends BaseTest{


    private static final String USER = "fake01@fake.com";
    private static final String PASSWORD = "fake";


    @Test
    public void testTWTaskList() {


        //perform login
        Reporter.log("Perform login");
        TWOverviewPage overviewPage = loginAs();

        //add taskList
        Reporter.log("Add new taskList");
        final String taskListName = "yissikList_" + System.currentTimeMillis();
        TWTasksPage tasksPage = addTaskList(overviewPage, taskListName);

        //add tasks
        final String task1 = "task1";
        final String task2 = "task2";
        final String assignTaskTo = "fake01 fake01 (me)";
        Reporter.log("Add two tasks to \"" + taskListName +"\" taskList");
        tasksPage.selectTaskListToHandle(taskListName).clickAddNewTask();
        tasksPage.typeNewTaskName(task1).assignTaskTo(assignTaskTo).saveTask();
        tasksPage.typeNewTaskName(task2).assignTaskTo(assignTaskTo).saveTask();

        //verify tasks were added
        Reporter.log("Verify the two tasks exist");
        TWMilestonesPage milestonesPage = tasksPage.getMenu().milestones();
        tasksPage = milestonesPage.getMenu().tasks();
        Assert.assertTrue(tasksPage.isElementExist(By.linkText(taskListName)), "taskList [" + taskListName + "] not exists");
        tasksPage.selectTaskListToHandle(taskListName);
        List<String> tasks = tasksPage.getTasksFromTask();
        Assert.assertEquals(tasks.size(), 2);
        Assert.assertTrue(tasks.contains(task1), "task [" + task1  +"] does not exist");
        Assert.assertTrue(tasks.contains(task2), "task [" + task2  +"] does not exist");

        //delete taskList
        Reporter.log("Delete the added taskList");
        tasksPage = tasksPage.selectTaskListToHandle(taskListName).deleteTaskList();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        //assert deletion
        Assert.assertFalse(tasksPage.isElementExist(By.linkText(taskListName)), "taskList [" + taskListName + "] does exists");


    }

    @Test
    public void testTWMilestone(){

        //perform login
        Reporter.log("Perform login");
        TWOverviewPage overviewPage = loginAs();

        //add taskList
        Reporter.log("Add new taskList");
        final String taskListName = "yissikList_" + System.currentTimeMillis();
        TWTasksPage tasksPage = addTaskList(overviewPage, taskListName);

        //add milestone
        Reporter.log("Add new milestone");
        TWMilestonesPage milestonesPage = tasksPage.getMenu().milestones();
        final String milestoneName = "yissikMilestone_" + System.currentTimeMillis();
        TWAddNewMilestonePage newMilestonePage = milestonesPage.clickAddNewMilestone();
        milestonesPage = newMilestonePage.typeName(milestoneName).saveNewMilestone();

        //attach taskList to milestone
        Reporter.log("Attach taskList to milestone");
        milestonesPage.selectMilestoneToHandle(milestoneName).hoverOnMilestone().clickAttachTaskList().selectTaskListToAttach(taskListName);

        //verify taskList attached to milestone
        Reporter.log("Verify taskList attached to milestone");
        tasksPage = milestonesPage.getMenu().tasks();
        tasksPage.isElementExist(By.xpath("//a[text()='" + taskListName + "']//../..//a[text()='"+milestoneName+"']"));

    }

    private TWOverviewPage loginAs() {
        TWLoginPage loginPage = new TWLoginPage(driver);
        loginPage.typeUserName(setup.getDefaultUser());
        loginPage.typePassword(setup.getDefaultPassword());
        return loginPage.login();
    }

    private TWTasksPage addTaskList(TWOverviewPage overviewPage, String taskListName) {
        TWTasksPage tasksPage = overviewPage.getMenu().tasks();
        TWAddTaskListModule addTaskListModule = tasksPage.clickOnAddTaskList();
        addTaskListModule.typeTaskListName(taskListName);
        tasksPage = addTaskListModule.clickOnAddTaskList();
        return tasksPage;
    }


}
