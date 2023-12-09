package Steps;

import Pages.LoginPage;
import Pages.ProfilePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class StepDefinition {

    public static WebDriver driver;
    public LoginPage loginPage;
    public ProfilePage profilePage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
    }


    @Given("User is on login page")
    public void user_is_on_login_page() {
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @When("User inputs valid username {string}")
    public void user_inputs_username(String username) {
        loginPage.inputUsername(username);
    }

    @And("User inputs valid password {string}")
    public void user_inputs_password(String password) {
        loginPage.inputPassword(password);
    }

    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLogInButton();
    }

    @Then("User is logged in")
    public void user_is_logged_in() {
        Assert.assertTrue(profilePage.logOutButton.isDisplayed());
    }

    @Then("User is not logged in")
    public void user_is_not_logged_in() {
        Assert.assertTrue(loginPage.error.isDisplayed());
        Assert.assertEquals(loginPage.error.getText(), "Your username is invalid!\n" + "×");
    }


}
