package automation.todoist;

import automation.control.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProjectsSection {
    public Button addProject = new Button(By.xpath("//h1[text()='Proyectos']/../../../../../..//button[@aria-disabled=\"false\"]"));

    public boolean getProject (String name){
        return new Button(By.xpath(String.format("//span[text()='%s']",name))).isControlDisplayed();
    }

}
