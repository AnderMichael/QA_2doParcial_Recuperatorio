package filaB;

import automation.session.Session;
import automation.todoist.*;
import org.junit.jupiter.api.*;

import java.util.Random;

public class Exercise3Test {
    MainPage mainPage = new MainPage();
    SignInSection signInSection = new SignInSection();
    MenuSection menuSection = new MenuSection();
    ProjectsSection projectsSection = new ProjectsSection();

    AddProjectSection addProjectSection = new AddProjectSection();

    static String newAccount;
    static String newPassword;
    static String newUsername;

    static String newProject;
    static Random random = new Random();


    @BeforeAll
    public static void setup() {
        newAccount = String.format("andersito%d@gmail.com", random.nextInt());
        newPassword = "HugoNoTeComasEsaHamburguesa";
        newUsername = "Andersaurio wrey";
        newProject = "Proyecto final";
    }

    @BeforeEach
    public void open() {
        Session.getInstance().getBrowser().get("https://todoist.com/app/");
    }

    @AfterEach
    public void close() {
        Session.getInstance().closeSession();
    }

    @Test
    public void createUserProject() throws InterruptedException {
        Thread.sleep(2000);
        mainPage.signInButton.click();
        creatingUser();
        menuSection.projects.click();
        projectsSection.addProject.click();
        addProjectSection.nameProject.setText("PrimeraTarea");
        addProjectSection.addButton.click();
        Assertions.assertTrue(projectsSection.getProject("PrimeraTarea"), "No se creo el proyecto");
    }

    public void creatingUser() throws InterruptedException {
        signInSection.emailInput.setText(newAccount);
        signInSection.passInput.setText(newPassword);
        signInSection.createButton.click();
        Thread.sleep(5000);

        Assertions.assertTrue(menuSection.projects.isControlDisplayed(),
                "ERROR al iniciar sesion");
    }

}
