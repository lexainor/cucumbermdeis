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


public class ClientePageDefinition {
    public static WebDriver driver;
    @Given("Ingresar al formulario de registro de cliente en la  aplicación")
    public void ingresar_al_formulario_de_registro_de_cliente_en_la_aplicación() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:3000/cliente");

    }
    @When("completar todos los campos requeridos")
    public void completar_todos_los_campos_requeridos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement nombre = wait.until(ExpectedConditions.elementToBeClickable(By.id("nombre")));
        nombre.sendKeys("Pedro");
        WebElement apellido = wait.until(ExpectedConditions.elementToBeClickable(By.id("apellidos")));
        apellido.sendKeys("Picapiedra");

        WebElement numDocumento = wait.until(ExpectedConditions.elementToBeClickable(By.id("numDocumento")));
        numDocumento.sendKeys("123456879");


        WebElement tipoDocumento = wait.until(ExpectedConditions.elementToBeClickable(By.id("tipoDocumento")));
        tipoDocumento.sendKeys("2");

        WebElement codCliente = wait.until(ExpectedConditions.elementToBeClickable(By.id("codCliente")));
        codCliente.sendKeys("C001");

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        email.sendKeys("dddd@dd.com");

        WebElement telefono = wait.until(ExpectedConditions.elementToBeClickable(By.id("telefono")));
        telefono.sendKeys("1");


        WebElement direccion = wait.until(ExpectedConditions.elementToBeClickable(By.id("direccion")));
        direccion.sendKeys("los lotes");
    }
    @When("Verificar que los datos cumplan con las validaciones de ci, nit y email")
    public void verificar_que_los_datos_cumplan_con_las_validaciones_de_ci_nit_y_email() {

    }
    @When("presionar el botón de registrar cliente")
    public void precionar_el_boton_de_registrar_cliente() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement registrar = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        registrar.click();
    }
    @Then("El sistema debe mostrar un mensaje de registro exitoso")
    public void el_sistema_debe_mostrar_un_mensaje_de_registro_exitoso() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement mensaje = wait.until(ExpectedConditions.elementToBeClickable(By.id("mesageResponse")));
        Assert.assertEquals("Cliente registrado correctamente", mensaje.getText());
    }

}
