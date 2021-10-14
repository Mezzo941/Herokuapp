import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest{

    @Test
    public void FileUploadedSuccessfully(){
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys("C:/Users/Mezzo/Downloads/1920x1200_1633616315162.jpeg");
        driver.findElement(By.cssSelector("[value=Upload]")).click();
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(),"1920x1200_1633616315162.jpeg");
    }

}
