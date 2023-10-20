package filaC;

import automation.session.Session;
import automation.todoly.MainPage;
import automation.todoly.MenuSection;
import automation.todoly.SettingsSection;
import automation.todoly.SignInSection;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;

import java.util.Random;

public class Exercise4Test {
    MainPage mainPage = new MainPage();
    SignInSection signInSection = new SignInSection();
    MenuSection menuSection = new MenuSection();

    SettingsSection settingsSection = new SettingsSection();

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
        Session.getInstance().getBrowser().get("https://todo.ly/");
    }

    @AfterEach
    public void close() {
        Session.getInstance().closeSession();
    }

    @Test
    public void createUserProject() throws InterruptedException {
        mainPage.signInButton.click();
        creatingUser();
        deletingUser();
        Assertions.assertTrue(mainPage.signInButton.isControlDisplayed(),
                "ERROR al borrar usuario");
    }

    public void creatingUser() {
        signInSection.fullNameInput.setText(newUsername);
        signInSection.emailInput.setText(newAccount);
        signInSection.passwordInput.setText(newPassword);
        signInSection.check.click();
        signInSection.signin.click();
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR al iniciar sesion");
    }

    public void deletingUser() throws InterruptedException {
        menuSection.settingsButton.click();
        settingsSection.accountButton.click();
        settingsSection.deleteButton.click();
        Thread.sleep(2000);
        Alert alert = Session.getInstance().getBrowser().switchTo().alert();
        alert.accept();
    }

}
