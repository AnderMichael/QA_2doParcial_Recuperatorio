package automation.todoist;

import automation.control.Button;
import automation.control.TextBox;
import org.openqa.selenium.By;

public class TaskCard {
    public TextBox taskName = new TextBox(By.xpath("//p[@data-placeholder=\"Task name\"]"));
    public Button button = new Button(By.xpath("//button[@data-testid=\"task-editor-submit-button\"]"));
}
