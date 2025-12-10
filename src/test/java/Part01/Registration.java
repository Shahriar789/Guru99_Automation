package Part01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        monthDropdown.selectByVisibleText("January");
        Select yearDropdown = new Select(driver.findElement(By.id("user_dateofbirth_1i")));
        yearDropdown.selectByVisibleText("1995");

        //checkbox
        driver.findElement(By.id("licencetype_f")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        //dropdown_2
        Select licencePeriod = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/form[1]/div[2]/div[5]/select[1]")));
        licencePeriod.selectByVisibleText("5 years");



        //dropdown_3

        Select occupation = new Select(driver.findElement(By.id("user_occupation_id")));
        occupation.selectByVisibleText("Engineer");

        driver.findElement(By.id("user_address_attributes_street")).sendKeys("123 Main St");
        driver.findElement(By.id("user_address_attributes_city")).sendKeys("Anytown");
        driver.findElement(By.id("user_address_attributes_county")).sendKeys("Anycounty");
        driver.findElement(By.id("user_address_attributes_postcode")).sendKeys("12345");

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
