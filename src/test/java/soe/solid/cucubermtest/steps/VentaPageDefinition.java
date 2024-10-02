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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VentaPageDefinition {
    public static WebDriver driver;

    @Given("Ingresar al formulario de registro de venta en la aplicación")
    public void ingresar_al_formulario_de_registro_de_venta_en_la_aplicación() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:3000/venta");
    }

    @When("seleccionar el producto {string}")
    public void seleccionar_el_producto(String productoSeleccionado) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement producto = wait.until(ExpectedConditions.elementToBeClickable(By.id("producto")));
        Select productoSelect = new Select(producto);  // Usa el select para manejar dropdowns
        productoSelect.selectByVisibleText(productoSeleccionado);  // Selecciona el producto según su nombre visible
    }

    @When("completar los campos de detalle del producto")
    public void completar_los_campos_de_detalle_del_producto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement cantidad = wait.until(ExpectedConditions.elementToBeClickable(By.id("cantidad")));
        cantidad.clear();
        cantidad.sendKeys("2");  // Define la cantidad del producto como 2
    }

    @When("completar observaciones con {string}")
    public void completar_observaciones_con(String observacionesTexto) {
        WebElement observaciones = driver.findElement(By.id("observaciones"));
        observaciones.clear();
        observaciones.sendKeys(observacionesTexto);  // Llena el campo de observaciones
    }

    @When("ingresar descuento global de {string}")
    public void ingresar_descuento_global_de(String descuento) {
        WebElement descuentoGlobal = driver.findElement(By.id("descuentoGlobal"));
        descuentoGlobal.clear();
        descuentoGlobal.sendKeys(descuento);  // Llena el campo de descuento global
    }

    @When("presionar el botón de registrar venta")
    public void presionar_el_boton_de_registrar_venta() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement registrar = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        registrar.click();
    }

    @Then("El sistema debe mostrar registro exitoso")
    public void el_sistema_debe_mostrar_un_mensaje_de_registro_exitoso() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement mensaje = wait.until(ExpectedConditions.elementToBeClickable(By.id("mesageResponse")));
        Assert.assertEquals("Venta registrada correctamente", mensaje.getText());
    }
}