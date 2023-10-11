package Testcases;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Testcases_Practico {
	@Test(description = "Validar que las busquedas en la pagina Ecommerce funcionen")
	public void ValidarBusquedaMusimundo() throws Exception {
		// Abrimos el navegador
		Reporter.log("Se abre Navegador");
		System.out.println("Se abre el navegador");
		System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Navegamos a la pagina de Musimundo
		Reporter.log("Ingresar a Musimundo.com");
		System.out.println("Ingresar a Musimundo.com");
		driver.get("https://www.musimundo.com/");
		//Buscamos el elemento SearchInput
		Reporter.log("Visualizar la caja de busqueda");
		System.out.println("Visualizar  la caja de busqueda");
		WebElement searchInput = driver.findElement(By.xpath("//input[@id='busca-v']"));
		Assert.assertTrue(searchInput.isDisplayed());
		//Tipear la palabra Celulares
		Reporter.log("Tipear la palabra Celulares");
		System.out.println("Tipear la palabra Celulares");
		searchInput.sendKeys("Celulares");
		// Hacemos enter en la caja de busqueda
		Reporter.log("Se presiona enter");
		System.out.println("Se presiona enter");
		Thread.sleep(2000);
		searchInput.submit();
		// Identificamos el resultado
		Reporter.log("Se identifica el resultado de la pagina");
		System.out.println("Se identifica el resultado de la pagina");
		WebElement tituloResultado = driver.findElement(By.xpath("//div[@class='col span_5']"));
		System.out.println("Texto encontrado " + tituloResultado.getText());
		// Verificamos que el titulo se muestre
		Reporter.log(" Se muestra el titulo");
		System.out.println("Se muestra el titulo");
		// Cerramos el navegador
		Reporter.log("Se cierra el navegador");
		System.out.println("Se cierra el navegador");
		Assert.assertTrue(tituloResultado.isDisplayed());
		driver.close();
	}


	@Test(description = "Validar doble busqueda en la pagina Ecommerce")
	public void ValidarDobleMusimundo() throws Exception {
		// Abrimos el navegador
		Reporter.log("Se abre Navegador");
		System.out.println("Se abre el navegador");
		System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Navegamos a la pagina de Musimundo
		Reporter.log("Ingresar a Musimundo.com");
		System.out.println("Ingresar a Musimundo.com");
		driver.get("https://www.musimundo.com/");
		// Buscamos el elemento SearchInput
		Reporter.log("Visualizar la caja de busqueda");
		System.out.println("Visualizar  la caja de busqueda");
		WebElement searchInput1 = driver.findElement(By.xpath("//input[@id='busca-v']"));
		Assert.assertTrue(searchInput1.isDisplayed());
		// Tipear la palabra Celulares
		Reporter.log("Tipear la palabra Notebooks");
		System.out.println("Tipear la palabra Notebooks");
		searchInput1.sendKeys("Notebooks");
		// Hacemos enter en la caja de busqueda
		Reporter.log("Se presiona enter");
		System.out.println("Se presiona enter");
		Thread.sleep(2000);
		searchInput1.submit();
		// Identificamos el resultado
		Reporter.log("Se identifica el resultado de la pagina");
		System.out.println("Se identifica el resultado de la pagina");
		WebElement tituloResultado = driver.findElement(By.xpath("//div[@class='col span_5']"));
		System.out.println("Texto encontrado " + tituloResultado.getText());
		// Verificamos que el titulo se muestre
		Reporter.log(" Se muestra el titulo");
		System.out.println("Se muestra el titulo");
		// Cerramos el navegador
		Reporter.log("Se cierra el navegador");
		System.out.println("Se cierra el navegador");
		Assert.assertTrue(tituloResultado.isDisplayed());
		driver.close();
	}

}
	