package automation.todoly;

import automation.control.Button;
import automation.control.Project;
import automation.control.Projects;
import automation.control.TextBox;
import org.openqa.selenium.By;

import java.util.List;

public class ProjectsSection {

    public Button addProjectButton = new Button(By.xpath("//div[@class=\"AddProjectLiDiv\"]"));
    public TextBox textBoxProjectName = new TextBox(By.id("NewProjNameInput"));
    public Button addButton = new Button(By.id("NewProjNameButton"));

    private Projects projects;

    public List<Project> getProjects(String projectName){
        projects =  new Projects(By.xpath(String.format("//td[text()='%s']", projectName)));
        return projects.getList();
    }
}
