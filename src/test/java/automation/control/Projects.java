package automation.control;

import org.openqa.selenium.By;

import java.util.List;

public class Projects extends GroupControl {
    private List<Project> list;

    public Projects(By locator) {
        super(locator);
    }

    public List<Project> getList() {
        getGroup();
        list = controls.stream().map(element -> {
            Project project = new Project(element.locator);
            project.control = element.control;
            return project;
        }).toList();
        return list;
    }
}
