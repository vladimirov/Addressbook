package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\Addressbook\\src\\main\\resources\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        this.driver = new ChromeDriver(capabilities);
        this.driver.manage().window().maximize();
        driver.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    private void login(String username, String password) {
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(username);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    protected void returnToGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    protected void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    protected void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    protected void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    protected void goToGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    protected void deleteSelectedGroups() {
        driver.findElement(By.name("delete")).click();

    }

    protected void selectGroup() {
        driver.findElement(By.name("selected[]")).click();
    }
}
