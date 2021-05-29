package com.capacitacion.semillero;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestYoutube {
	private WebDriver driver;
	private WebDriverWait wait;

	@Before
	public void preconditions() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
	}

//	@Test
	public void goToYoutube() {
		driver.navigate().to("https://www.youtube.com/");
		By idCajaTexto = By.id("search");
		WebElement cajaTextoBusqueda = driver.findElement(idCajaTexto);
		cajaTextoBusqueda.sendKeys("musica");
		cajaTextoBusqueda.sendKeys(Keys.DOWN);
		By sugerencia = By.xpath("//li[@dir='ltr']//*[contains(text(),'electronica')]");
		wait.until(ExpectedConditions.elementToBeClickable(sugerencia));
		driver.findElement(sugerencia).click();
		espera(5);
		List<WebElement> listaResultado = driver.findElements(By.id("title-wrapper"));
		System.out.println("La cantidad de elementos encontrados es: " + listaResultado.size());
		String valorEsperado = "Summer Mix 2021 - Best Deep House Remixes Of Popular Songs Music Mix By Magic";
		assertEquals(valorEsperado, listaResultado.get(0));
	}

	@Test
	public void paginaMercadolibre() {
		driver.get("https://www.mercadolibre.com.co/");
		WebElement category = driver
				.findElement(By.cssSelector("body > header > div > div.nav-menu > ul > li:nth-child(2) > a"));
		Actions action = new Actions(driver);
		action.moveToElement(category).perform();
	}

	@After
	public void postconditions() {
		espera(5);
		driver.quit();
	}

	public void espera(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
