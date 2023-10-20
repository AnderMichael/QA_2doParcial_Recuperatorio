package automation.control;

import org.openqa.selenium.By;

public class Item extends Control{
    private String name;

    public String getName() {
        this.name = control.getText();
        return name;
    }

    public Item(By locator) {
        super(locator);
    }
}
