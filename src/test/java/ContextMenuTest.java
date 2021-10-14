import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    @Test
    public void contextMenuIsWork(){
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement window = driver.findElement(By.id("hot-spot"));
        action.contextClick(window).build().perform();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText,"You selected a context menu");
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.cssSelector("h3")).getText(),"Context Menu");
    }
}
