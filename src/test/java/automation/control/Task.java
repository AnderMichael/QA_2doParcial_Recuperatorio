package automation.control;

import org.openqa.selenium.By;

public class Task extends Control{
    private String name;

    public Task(By locator) {
        super(locator);
    }
    public String getName() {
        this.name = control.getText();
        return name;
    }
}
