import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicControlsTest extends BaseTest{

    @Test
    public void dynamicControlsWork(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls"); //открыли страничку
        WebElement checkBox = driver.findElement(By.cssSelector("[type=checkbox]")); //нашли чекбокс
        driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click(); //тыкнули на кнопку удалить чекбокс
        new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("message")))); //ждем сообщение
        boolean inputCondition;
        try {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            checkBox.click(); //проверяем что нет чекбокса и ловим эксепшен
        }
        catch (Exception exception){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        inputCondition = driver.findElement(By.cssSelector("[type=text]")).isEnabled();
        Assert.assertFalse(inputCondition); //проверяем что инпут дисаблед
        driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click(); //тыкаем на включение инпута;
        new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("message")))); //ждем сообщение
        inputCondition = driver.findElement(By.cssSelector("[type=text]")).isEnabled();
        Assert.assertTrue(inputCondition); //проверяем что инпут включился
    }

}
