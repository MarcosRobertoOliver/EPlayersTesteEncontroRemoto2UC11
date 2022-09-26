package eplayers.teste;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteEplayers {
	private ChromeDriver driver;
	
	@Before
	public void PreTeste() {
		
	//configurar o drive
		System.setProperty("webdriver.chrome.driver", "/Users/marcosrobertodeoliveira/chromedriver/chromedriver");
		
	//instanciar o driver/chrome
		
		driver = new ChromeDriver(); //abrir o Chrome
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/login");
	}
	
	@Test
	public void Teste() {
		
		String[] listaSenhas = {"senha1", "xpto", "generica", "12345678"};
		for(int tentativa =0; tentativa < listaSenhas.length; tentativa++) {
			
			try {
				
				WebElement inputNome    = driver.findElement(By.id("nome"));
				WebElement inputUsuario = driver.findElement(By.id("usuario"));
				WebElement inputSenha   = driver.findElement(By.id("senha"));
				WebElement inputSignin  = driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/button[1]"));
				
				inputNome .clear();
				inputUsuario.clear();
				inputSenha.clear();
					
					
					
					
					
				inputNome.sendKeys("Marcos Roberto de Oliveira");
				inputUsuario.sendKeys("mro@mro.com");
				inputSenha .sendKeys(listaSenhas[tentativa]);
				inputSignin.click();
				
				//pausar por 3 segundos
				Thread.sleep(3000);
				
				
			} catch(InterruptedException e) {
				e.printStackTrace();
				
			}
			
		}
		
		
		
	}
}
