package seleniumBascis;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestproject {

	WebDriver driver = new ChromeDriver();
	/* WebDriver driver2 = new FirefoxDriver(); */
	/* WebDriver driver3 = new EdgeDriver(); */

	String MyWebsite = "https://magento.softwaretestingboard.com/";
	String MyWebsite2 = "https://www.google.com/";

	String[] firstNames = { "ahmad", "ali", "anas", "omar", "ayat", "alaa", "sawsan", "Rama" };
	String[] LastNames = { "Khaled", "mustafa", "Mohammad", "abdullah", "malek", "omar" };

	Random rand = new Random();

	@BeforeTest
	public void MySetup() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(MyWebsite);
		/*
		 * driver.navigate().to(MyWebsite2); driver.navigate().back();
		 * driver.navigate().forward();
		 * System.out.println(driver.getCurrentUrl().toUpperCase());
		 * System.out.println(driver.getTitle()); Thread.sleep(2000);
		 * driver.navigate().refresh();
		 */

	}

	@Test(priority = 1)
	public void SignUp() throws InterruptedException {

		int RandomIndexForTheFirstName = rand.nextInt(firstNames.length);
		int RandomIndexForTheLastName = rand.nextInt(LastNames.length);

		String UserFirstName = firstNames[RandomIndexForTheFirstName];
		String UserLastName = LastNames[RandomIndexForTheLastName];

		int randomNumberForTheEmail = rand.nextInt(564548);
		String domainName = "@gmail.com";

		driver.findElement(By.partialLinkText("Create")).click();
		driver.findElement(By.linkText("Create an Account")).click();

		WebElement FirstNameInput = driver.findElement(By.id("firstname"));
		FirstNameInput.sendKeys(UserFirstName);
		WebElement LastNameInput = driver.findElement(By.id("lastname"));
		LastNameInput.sendKeys(UserLastName);
		WebElement EmailInput = driver.findElement(By.id("email_address"));
		EmailInput.sendKeys(UserFirstName + UserLastName + randomNumberForTheEmail + domainName);
		WebElement PasswordInput = driver.findElement(By.id("password"));
		PasswordInput.sendKeys("?123456Sara");
		WebElement ConfirmPasswordInput = driver.findElement(By.id("password-confirmation"));
		ConfirmPasswordInput.sendKeys("?123456Sara");
		WebElement CreateAccountInput = driver
				.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span"));
		Thread.sleep(4000);
		CreateAccountInput.click();

	}

	@Test(priority = 2)

	public void Logout() throws InterruptedException {

		Thread.sleep(5000);
		String LogoutURl = "https://magento.softwaretestingboard.com/customer/account/logout/";
		driver.get(LogoutURl);
	}
}
