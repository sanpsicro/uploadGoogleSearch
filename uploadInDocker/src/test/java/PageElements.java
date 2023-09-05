import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageElements {

    // DECLARE ELEMENTS REGION
    @FindBy(how= How.XPATH , using="")
    private WebElement element1 = null;

    //


    // DATA ACCESS

    public WebElement Element1() { return element1;}

}
