package automation.todoly;

import automation.control.Button;
import org.openqa.selenium.By;

public class MenuSection {

    public Button logoutButton = new Button(By.xpath("//a[text()='Logout']"));
    public Button addTask = new Button(By.xpath("//button[span[text()='Add task']]"));
    public Button deplegableProfile = new Button(By.xpath("//div[@class='ZmV8mtF']/button"));

    public Button settingsButton = new Button(By.xpath("//a[text()='Settings']"));

}
