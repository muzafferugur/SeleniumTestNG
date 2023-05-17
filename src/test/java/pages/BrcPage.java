package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BrcPage {
    BrcPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
