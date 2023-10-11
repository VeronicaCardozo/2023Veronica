package navegadores;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class drivers {
	public static WebDriver conectar() {
		System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
}
