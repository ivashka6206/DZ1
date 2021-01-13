import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {
    private Logger logger =LogManager.getLogger(SampleTest.class);
    protected static WebDriver driver;
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }
    @Test
  public void openPage() {
   driver.get (cfg.url());
   logger.info("Открыта страница Отус");
}
@After
public void setDown (){
        if (driver!= null){
            driver.quit();
            logger.info("Драйвер успешно закрыт");
        }
}
}


