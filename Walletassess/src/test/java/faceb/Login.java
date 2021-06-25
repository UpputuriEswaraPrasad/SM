package faceb;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	public static RemoteWebDriver driver;
    @Test
	public static  Object Homepage()
	{
		 String email="eswaraprasad87@gmail.com";
		 String Password="Sairam@139";
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Browser name");
		String bn=sc.nextLine();
		
		if(bn.equalsIgnoreCase("chrome"))
		{
			 ChromeOptions ops = new ChromeOptions();
	         ops.addArguments("--disable-notifications");
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver(ops);
		}
		else if(bn.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if (bn.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(bn.equalsIgnoreCase("Opera"))
		{
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
			
		}
		else 
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
		driver.get("http://www.facebook.com");
		Scanner user1=new Scanner(System.in);
		String user=user1.nextLine();
		System.out.println("Enter the user name");
		WebElement UserName=driver.findElement(By.id("email"));
		UserName.sendKeys(user);
		Scanner pass=new Scanner(System.in);
		String pass1=pass.nextLine();
		WebElement Password1=driver.findElement(By.name("pass"));
		Password1.sendKeys(pass1);
		driver.findElement(By.name("login")).click();
		driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
		return Homepage();
		
	
		
		

	}

}
