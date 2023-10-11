package Testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Testcases_wiki {
	@Test(description = "Validar que las busquedas en la pagina Wikipedia funcionen")
		public void ValidarBusquedas() throws Exception {
			// Abrimos el navegador
			Reporter.log("Se abre Navegador");
			System.out.println("Se abre el navegador");
			System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			//Navegamos a la pagina de Wikipedia.org
			Reporter.log("Ingresar a Wikipedia.org");
			System.out.println("Ingresar a Wikipedia.org");
			driver.get("http://wikipedia.org/");
			//Buscamos el elemento SearchInput
			Reporter.log("Visualizar la caja de busqueda");
			System.out.println("Visualizar  la caja de busqueda");
			WebElement searchInput = driver.findElement(By.xpath("//input[@id='searchInput']"));
			Assert.assertTrue(searchInput.isDisplayed());
			//Tipear la palabra Celulares
			Reporter.log("Tipear la palabra Barbie");
			System.out.println("Tipear la palabra Barbie");
			searchInput.sendKeys("Barbie");
			// Hacemos enter en la caja de busqueda
			Reporter.log("Se presiona enter");
			System.out.println("Se presiona enter");
			Thread.sleep(2000);
			searchInput.submit();
			// Identificamos el resultado
			Reporter.log("Se identifica el resultado de la pagina");
			System.out.println("Se identifica el resultado de la pagina");
			WebElement tituloResultado = driver.findElement(By.id("firstHeading"));
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



