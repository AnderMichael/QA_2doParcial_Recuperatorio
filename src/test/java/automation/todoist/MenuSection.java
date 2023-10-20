package automation.todoist;

import automation.control.Button;
import org.openqa.selenium.By;

public class MenuSection {
    public Button addTask = new Button(By.xpath("//button[span[text()='Add task']]"));
    public Button deplegableProfile = new Button(By.xpath("//div[@class='ZmV8mtF']/button"));

//    public Button

    public Button inbox = new Button(By.xpath("//div[text()='Inbox']"));
    public Button projects = new Button(By.xpath("//div[text()='Proyectos']"));
}
