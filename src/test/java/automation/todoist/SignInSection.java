package automation.todoist;

import automation.control.Button;
import automation.control.TextBox;
import org.openqa.selenium.By;

public class SignInSection {
    public TextBox passInput = new TextBox(By.xpath("//input[@type=\"password\"]"));
    public TextBox emailInput = new TextBox(By.xpath("//input[@placeholder=\"Introduce tu email...\"]"));
    public Button createButton = new Button(By.xpath("//button[span[text()='Registrarme con mi email']]"));
}
