package com.ilrd.test;

import com.ilrd.pages.BasePage;
import com.ilrd.pages.teamwork.TWLoginPage;
import com.ilrd.pages.teamwork.TWTasksPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by student on 23/12/15.
 */
public class TeamWorkTest extends BaseTest{


    private static final String USER = "fake01@fake.com";
    private static final String PASSWORD = "fake";
    private static final String ASSIGN_TASK_TO = "fake01 fake01 (me)";
    private static final String TASK1 = "task1";
    private static final String TASK2 = "task2";
    private static String taskListName;
    private static String milestoneName;




    public TeamWorkTest() {
        super("https://topq.teamwork.com");
    }

    @BeforeMethod
    public void fixture(){

        taskListName = "yissikList_" + System.currentTimeMillis();
        milestoneName = "yissikMilestone_" + System.currentTimeMillis();

    }

    @Test
    public void testTWTaskList() {

        TWLoginPage p = new TWLoginPage(driver);

        BasePage page =

                p.loginAs(USER, PASSWORD).getMenu().tasks().addTaskList().
                typeTaskListName(taskListName).addTaskList().
                selectTaskListToHandle(taskListName).clickAddNewTask().
                typeNewTaskName(TASK1).assignTaskTo(ASSIGN_TASK_TO).saveTask().
                typeNewTaskName(TASK2).assignTaskTo(ASSIGN_TASK_TO).saveTask().
                getMenu().milestones().getMenu().tasks().selectTaskListToHandle(taskListName);



        Assert.assertTrue(page.isElementExist(By.linkText(taskListName)), "taskList [" + taskListName + "] not exists");


        List<String> tasks = ((TWTasksPage)page).getTasksFromTask();

        Assert.assertTrue(tasks.contains(TASK1), "task [" + TASK1  +"] does not exist");
        Assert.assertTrue(tasks.contains(TASK2), "task [" + TASK2  +"] does not exist");


        ((TWTasksPage) page).getMenu().tasks().selectTaskListToHandle(taskListName).deleteTaskList();

        //assert deletion
        Assert.assertFalse(page.isElementExist(By.linkText(taskListName)), "taskList [" + taskListName + "] does exists");


    }

    @Test
    public void testTWMilestone(){


        TWLoginPage p = new TWLoginPage(driver);

        BasePage page =
                        p.loginAs(USER, PASSWORD).
                                getMenu().tasks().
                                addTaskList().
                        typeTaskListName(taskListName).addTaskList().
                                getMenu().milestones().
                                clickAddNewMilestone().typeName(milestoneName).saveNewMilestone().
                                selectMilestoneToHandle(milestoneName).clickAttachTaskList().selectTaskListToAttach(taskListName).
                getMenu().tasks();



        page.isElementExist(By.xpath("//a[text()='" + taskListName + "']//../..//a[text()='"+milestoneName+"']"));



    }


}
