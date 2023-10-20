package automation.todoly;

import automation.control.Button;
import automation.control.TextBox;
import org.openqa.selenium.By;

public class SettingsSection {
    public TextBox fullNameBox = new TextBox(By.id("FullNameInput"));
    public Button confirmationButton = new Button(By.xpath("//span[@class='ui-button-text' and text()='Ok']"));
    public Button accountButton = new Button(By.xpath("//a[text()='Account']"));
    public TextBox deleteButton = new TextBox(By.xpath("//input[@name=\"DeleteAccountBtn\"]"));

    public TextBox oldPass = new TextBox(By.id("TextPwOld"));
    public TextBox newPass = new TextBox(By.id("TextPwNew"));
}
