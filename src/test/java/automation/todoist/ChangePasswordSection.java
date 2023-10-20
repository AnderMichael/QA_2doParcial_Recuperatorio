package automation.todoist;

import automation.control.TextBox;
import org.openqa.selenium.By;

public class ChangePasswordSection {
    public TextBox actualPass = new TextBox(By.xpath("//input[@type=\"password\"]"));
    public TextBox newPass = new TextBox(By.xpath("//input[@aria-describedby=\"password-validation-description\"]"));
    public TextBox confirmNewPass = new TextBox(By.xpath("//span[text()='Confirm new password']/../../..//input"));
    public TextBox buttonConfirm = new TextBox(By.xpath("//button[@type=\"submit\"]"));

}
