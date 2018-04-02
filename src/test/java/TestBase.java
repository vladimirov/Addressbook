

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

//    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser"));

    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
