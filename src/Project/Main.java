package Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	public static void main(String[] args) throws InterruptedException 
	
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Neweclipse\\HotelApp\\src\\Project\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.adactin.com/HotelApp//index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//Login Page Validation
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("nsampath");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Athvin@28");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		WebElement txt = driver.findElement(By.xpath("//td[contains(text(),'Welcome to AdactIn Group of Hotels')]"));
		String txt1 = txt.getText();
		
		if(txt1.equals("Welcome to AdactIn Group of Hotels"))
		{
			System.out.println("Login is Successfull");
		}
		
		//Hotel Search Page Validation 
		
		WebElement loc = driver.findElement(By.id("location"));
		Select location = new Select(loc);
		location.selectByVisibleText("Los Angeles");
		
		WebElement hotel = driver.findElement(By.id("hotels"));
		Select hotels = new Select(hotel);
		hotels.selectByVisibleText("Hotel Creek");
		
		WebElement roomt = driver.findElement(By.id("room_type"));
		Select room = new Select(roomt);
		room.selectByVisibleText("Double");
		
		WebElement roomns = driver.findElement(By.id("room_nos"));
		Select roomss = new Select(roomns);
		roomss.selectByVisibleText("9 - Nine");
		
		driver.findElement(By.id("datepick_in")).sendKeys("31/06/2019");
		driver.findElement(By.id("datepick_out")).sendKeys("31/08/2019");
		
		WebElement adr = driver.findElement(By.id("adult_room"));
		Select adult = new Select(adr);
		adult.selectByVisibleText("3 - Three");
		
		WebElement chilr = driver.findElement(By.id("child_room"));
		Select chil = new Select(chilr);
		chil.selectByVisibleText("4 - Four");
		
		driver.findElement(By.id("Submit")).click();
		
		//Select Hotel Validation
		
		WebElement click = driver.findElement(By.id("radiobutton_0"));
		click.click();
		if (click.isSelected())
		{
			System.out.println("The Selected hotel is successfully selected");
		}
		
		driver.findElement(By.id("continue")).click();
		
		driver.findElement(By.id("first_name")).sendKeys("Navin");
		driver.findElement(By.id("last_name")).sendKeys("Sampath");
		driver.findElement(By.id("address")).sendKeys("Qtrs Sathuvachari Vellore-9");
		driver.findElement(By.id("cc_num")).sendKeys("4444333322221111");
		
		
		WebElement cc = driver.findElement(By.id("cc_type"));
		Select cct = new Select(cc);
		cct.selectByVisibleText("VISA");
		
		WebElement expmm = driver.findElement(By.id("cc_exp_month"));
		Select mm = new Select(expmm);
		mm.selectByVisibleText("October");
		
		WebElement expyy = driver.findElement(By.id("cc_exp_year"));
		Select yy = new Select(expyy);
		yy.selectByVisibleText("2021");
		
		driver.findElement(By.id("cc_cvv")).sendKeys("288");
		driver.findElement(By.id("book_now")).click();
		
		
		//Getting the order text box values 
		
	WebDriverWait ww = new WebDriverWait(driver, 20);
	 WebElement ttt = driver.findElement(By.id("order_no"));
	 String txtx = ttt.getAttribute("value");
	ww.until(ExpectedConditions.visibilityOf(ttt));
	 System.out.println("The Order id is : " + txtx);
	
	 driver.findElement(By.id("logout")).click();
	 
	 driver.close();

	}

}
