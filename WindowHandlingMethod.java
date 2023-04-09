package MainPackage.SeleniumChromeDriver.locators.windowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandlingMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver wd = new ChromeDriver();
        wd.get("https://courses.letskodeit.com/practice");
        WebElement we = wd.findElement(By.id("openwindow"));
        we.click();
        System.out.println(we.getText());
        String getParentId = wd.getWindowHandle();
        Set<String> getChildId = wd.getWindowHandles();
        System.out.println(getParentId);
        System.out.println(getChildId);
        System.out.println(wd.getTitle());

        for (String s:getChildId)
            if (!getParentId.equals(s))
                wd.switchTo().window(s);
        System.out.println(wd.getTitle());
        Thread.sleep(3000);
        wd.close();


        wd.switchTo().window(getParentId);
        Thread.sleep(3000);

        wd.close();
    }
}
