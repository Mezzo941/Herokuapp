import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest{

    @Test
    public void IframeIsWork(){
        driver.get("http://the-internet.herokuapp.com/iframe");
        Assert.assertEquals(driver.findElement(By.cssSelector(".tox-tbtn__select-label")).getText(),"Paragraph");
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        Assert.assertEquals(driver.findElement(By.cssSelector("p")).getText(),"Your content goes here.");
    }

}
