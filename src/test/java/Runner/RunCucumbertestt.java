package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Resources/feature/InserirContaOutroJeitoExemplo.feature",
        glue = {"Steps"},
        tags = {"~@ignore"},
        plugin = "pretty",
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        dryRun = false,
        strict = false
)

    public class RunCucumbertestt {

    @BeforeClass
    public static void Reset(){
        WebDriver drive = new ChromeDriver();
        drive.get("http://seubarriga.wcaquino.me/login");
        drive.findElement(By.id("email")).sendKeys("petruciolima2406@hotmail.com");
        drive.findElement(By.id("senha")).sendKeys("1234");
        drive.findElement(By.cssSelector(".btn.btn-primary")).click();
        drive.findElement(By.cssSelector(".footer > span > a")).click();


    }


    }

