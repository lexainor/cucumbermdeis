package soe.solid.cucubermtest.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageDefinition {
    public static WebDriver driver;
    @Given("que navego a la página de inicio de la aplicación")
    public void que_navego_a_la_página_de_inicio_de_la_aplicación() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        //System.setProperties("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver(options);
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
    }

    @When("el usuario hace clic en el enlace Forgot Password")
    public void el_usuario_hace_clic_en_el_enlace() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement forgotPasswordLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//u[text()='Forgot Password?']")));
        forgotPasswordLink.click();
    }

    @Then("se debe mostrar un formulario para restablecer la contraseña")
    public void se_debe_mostrar_un_formulario_para_restablecer_la_contraseña() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(),"Password help assistance");
    }


}
