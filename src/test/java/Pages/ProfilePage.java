package Pages;

import Steps.StepDefinition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends StepDefinition {

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".icon-2x.icon-signout")
    public WebElement logOutButton;

    //--------------------

    public void clickOnLogOutButton() {
        logOutButton.click();
    }
}
