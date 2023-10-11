package Testcases;

import Metodosutiles.Utiles;
import navegadores.drivers;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testcase {
	WebDriver driver;

	@BeforeMethod()
	public void Precondicion() {
		// Abrimos el navegador
		driver = drivers.conectar();
		Utiles.reportes("Se abre Navegador");

		Utiles.reportes("Ingresar a Wikipedia.org");
		driver.get("http://wikipedia.org");
	}

	@AfterMethod()
	public void postcondiciones() throws Exception {
		// Cerramos el navegador
		Utiles.reportes("Se cierra el navegador");
		driver.close();
	}

	@DataProvider(name = "datos")
	public Object[][] createData() {
		return new Object[][] { 
			{ "SAN LUIS", "San Luis" }, 
			{ "BUENOS AIRES", "Buenos Aires" },
			{ "SAMSUNG", "Samsung" }, 
			{ "CHACO", "Chaco" },

		};

	}

	@DataProvider(name = "datosDos")
	public Object[][] createDataDos() {
		return new Object[][] { 
			{ "SAN LUIS", "San Luis" ,"SAMSUNG","Samsung"},
			//{"EL REY LEON", "El Rey Leon"},
			 

		};

	}

	@Test(dataProvider = "datos", description = "Validar que las busquedas en Wikipedia funcionan")
	public void ValidarBusquedaWikipedia(String varBuscar, String varResultado) throws Exception {
		// Buscamos el elemento SearchInput
		Utiles.reportes("Ir a la caja de busqueda");
		WebElement searchInput = driver.findElement(By.id("searchInput"));
		// Verificamos que el elemento se visualice
		Utiles.reportes("La caja de busqueda fue visualizada");
		Assert.assertTrue(searchInput.isDisplayed());
		// En la caja de busqueda tipeamos
		Utiles.reportes("Se tipea la palabra" + varBuscar);
		searchInput.sendKeys(varBuscar);
		// Hacemos enter en la caja de busqueda
		Utiles.reportes("Se presiona enter");
		//searchInput.sendKeys(Keys.ENTER);
		searchInput.submit();
		Thread.sleep(2000);// esperas
		// Identificamos el elemento de la pagina resultado
		Utiles.reportes("Se identifica el titulo de la pagina resultado ");
		WebElement tituloResultado = driver.findElement(By.id("firstHeading"));
		// Mostramos en consola cual es el titulo
		Utiles.reportes("Se muestra el titulo en la consola" + varResultado);
		System.out.println("Texto encontrado" + tituloResultado.getText());
		// Verificamos que el titulo se muestre
		Utiles.reportes("Se muestra el titulo");
		Assert.assertTrue(tituloResultado.isDisplayed());
		Assert.assertTrue(tituloResultado.getText().contains(varResultado));

	}

	@Test(dataProvider = "datosDos", description = "Verificar que se realice dos busqueda")
	public void verficarDobleBusqueda(String varBuscar, String varResultado, String varBuscarDos,String varResultadoDos) 
			throws Exception {
		// Buscamos el elemento SearchInput
		Utiles.reportes("Ir a la caja de busqueda");
		WebElement searchInput = driver.findElement(By.id("searchInput"));
		// Verificamos que el elemnto se visualice
		Utiles.reportes("La caja de busqueda fue visualizada");
		Assert.assertTrue(searchInput.isDisplayed());
		// En la caja de busqueda tipeamos Argentina
		Utiles.reportes("Se tipea la palabra" + varBuscar);
		searchInput.sendKeys(varBuscar);
		// Hacemos enter en la caja de busqueda
		Utiles.reportes("Se presiona enter");
		searchInput.submit();
		Thread.sleep(2000);// esperas
		WebElement titulolabel = driver.findElement(By.id("firstHeading"));
		Assert.assertTrue(titulolabel.getText().contains(varResultado), " No se encontro la palabra");
		WebElement cajadebusqueda = driver.findElement(By.xpath("//input[@id='searchInput']"));
		Assert.assertTrue(cajadebusqueda.isDisplayed(), " No se encontro la palabra");
		cajadebusqueda.sendKeys(varBuscarDos);
		//cajadebusqueda.sendKeys(Keys.ENTER);
		cajadebusqueda.submit();
		Thread.sleep(2000);
		titulolabel = driver.findElement(By.id("firstHeading"));
		Assert.assertTrue(titulolabel.getText().contains(varResultadoDos), " No se encontro la palabra");

	}

}
