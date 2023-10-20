package filaC;

import automation.session.Session;
import automation.todoist.AccountSection;
import automation.todoist.DesplegableSection;
import automation.todoist.TaskCard;
import automation.todoist.TaskSection;
import automation.todoist.LoginSection;
import automation.todoist.MenuSection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Exercise3Test {
    LoginSection loginSection = new LoginSection();
    MenuSection menuSection = new MenuSection();
    DesplegableSection desplegableSection = new DesplegableSection();
    AccountSection accountSection = new AccountSection();

    @BeforeEach
    public void open() {
        Session.getInstance().getBrowser().get("https://todoist.com/app/");
    }

    @AfterEach
    public void close() {
        Session.getInstance().closeSession();
    }

    @Test
    public void changeName() throws InterruptedException {
        String newName = "Andersaurio3";
        login();
        Thread.sleep(5000);
        menuSection.deplegableProfile.click();
        desplegableSection.configButton.click();
        accountSection.name.clearSetText(newName);
        accountSection.buttonUpdate.click();

        Thread.sleep(1000);
        accountSection.buttonClose.click();
        menuSection.deplegableProfile.click();
        desplegableSection.closeSession.click();
        Thread.sleep(2000);

        login();

        menuSection.deplegableProfile.click();
        desplegableSection.configButton.click();
        Assertions.assertEquals(accountSection.name.showText(), newName,"ERROR nombre nadaaaaaa");
    }

    public void login() {
        if(loginSection.loginButton.isControlDisplayed()){
            loginSection.loginButton.click();
        }
        loginSection.emailInput.setText("andersaurio@ander.com");
        loginSection.passwordInput.setText("Standbyme1");
        loginSection.confirmationButton.click();
    }
}
