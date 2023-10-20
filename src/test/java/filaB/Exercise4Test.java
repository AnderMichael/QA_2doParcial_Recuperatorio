package filaB;

import automation.session.Session;
import automation.todoly.*;
import org.junit.jupiter.api.*;

public class Exercise4Test {
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
    MenuSection menuSection = new MenuSection();
    SettingsSection settingsSection = new SettingsSection();

    @BeforeEach
    public void open() {
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @AfterEach
    public void close() {
        Session.getInstance().closeSession();
    }

    @Test
    public void changePassword() throws InterruptedException {
        String newPass = "Ander1";
        String currPass = "Standbyme1";
        // Entering web page and Settings Section
        login(currPass);
        menuSection.settingsButton.click();
        Thread.sleep(2000);
        Assertions.assertTrue(settingsSection.confirmationButton.isControlDisplayed(), "ERROR la sección SETTINGS no se abrió");

        // Setting a different value in fullName input and confirming changes
        settingsSection.oldPass.clearSetText(currPass);
        Thread.sleep(2000);
        settingsSection.newPass.clearSetText(newPass);
        Thread.sleep(2000);
        settingsSection.confirmationButton.click();
        //Closing session and quit of the menu section
        menuSection.logoutButton.click();
        Thread.sleep(2000);

        // Opening a session again and SETTINGS section to visualize changes
        login(newPass);
    }

    public void login(String pass) {
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText("andersaurio@ander.com");
        loginSection.pwdTextBox.setText(pass);
        loginSection.loginButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR al iniciar sesion");
    }
}
