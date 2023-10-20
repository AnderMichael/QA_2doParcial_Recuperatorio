package automation.todoly;

import automation.control.Button;
import org.openqa.selenium.By;

public class MainPage {

    public Button loginButton = new Button(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]"));

    public Button signInButton = new Button(By.xpath("//img[@src=\"/Images/design/pagesignup.png\"]"));

}
