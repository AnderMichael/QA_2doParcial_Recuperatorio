package automation.todoly;

import automation.control.Button;
import automation.control.TextBox;
import org.openqa.selenium.By;

public class SignInSection {

    public TextBox fullNameInput = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName"));
    public TextBox emailInput = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail"));
    public TextBox passwordInput = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword"));
    public Button check = new Button(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms"));

    public Button signin = new Button(By.id("ctl00_MainContent_SignupControl1_ButtonSignup"));
}
