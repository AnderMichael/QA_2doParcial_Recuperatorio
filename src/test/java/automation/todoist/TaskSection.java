package automation.todoist;

import automation.control.Task;
import org.openqa.selenium.By;

public class TaskSection {
    public Task task;

    public boolean taskExists(String name){
        task = new Task(By.xpath(String.format("//div[text()='%s']", name)));
        return task.isControlDisplayed();
    }
}
