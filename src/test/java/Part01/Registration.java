package Part01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Registration  {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/");
        driver.findElement(By.cssSelector("a[href='http://demo.guru99.com/insurance/v1/index.php']")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-default']")).click();
        driver.findElement(By.xpath("//select[@id='user_title']")).click();

        // Step 4: Locate dropdown
        WebElement dropdownElement = driver.findElement(By.id("user_title"));

        // Step 5: Create Select object
        Select titleDropdown = new Select(dropdownElement);

        // Step 6: Select by visible text
        titleDropdown.selectByVisibleText("Professor");

        // Step 7: Verify selection
        String selectedOption = titleDropdown.getFirstSelectedOption().getText();
        if (selectedOption.equals("Doctor")) {
            System.out.println("Dropdown selection successful!");
        } else {
            System.out.println("Dropdown selection failed!");
        }
        driver.findElement(By.id("user_firstname")).sendKeys("Shahriar");
        driver.findElement(By.id("user_surname")).sendKeys("Ifti");
        driver.findElement(By.id("user_phone")).sendKeys("1234567890");

        // Dropdown for Date of Birth
        Select dayDropdown = new Select(driver.findElement(By.id("user_dateofbirth_3i")));
        dayDropdown.selectByVisibleText("10");
        Select monthDropdown = new Select(driver.findElement(By.id("user_dateofbirth_2i")));
        monthDropdown.selectByVisibleText("May");
        Select yearDropdown = new Select(driver.findElement(By.id("user_dateofbirth_1i")));
        yearDropdown.selectByVisibleText("1990");

        //checkbox
        driver.findElement(By.id("licencetype_t")).click();

        Select licencePeriod = new Select(driver.findElement(By.id("user_licenceperiod")));
        licencePeriod.selectByVisibleText("5 years");
        Select occupation = new Select(driver.findElement(By.id("user_occupation_id")));
        occupation.selectByVisibleText("Engineer");


//        WebElement x = driver.findElement(By.id("user_dateofbirth_3i"));
//        Select y = new Select(x);
//        y.selectByVisibleText("13");
//
//        WebElement a = driver.findElement(By.id("user_dateofbirth_2i"));
//        Select b = new Select(a);
//        b.selectByVisibleText("May");
//
//        WebElement c = driver.findElement(By.id("user_dateofbirth_1i"));
//        Select d= new Select(c);
//        d.selectByVisibleText("2000");

        driver.quit();
    }
}
