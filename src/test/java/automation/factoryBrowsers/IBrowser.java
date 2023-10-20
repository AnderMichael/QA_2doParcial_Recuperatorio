package automation.factoryBrowsers;

// First we need to create an instance of navigator
// Using the correspondent drivers in resources directory

import org.openqa.selenium.WebDriver;

public interface IBrowser {
    // Method to instance a web driver
    WebDriver create();
}
