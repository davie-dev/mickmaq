package testapp;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Test de connexion et de déconnexion de l'application.
     * @throws URISyntaxException 
     */
    @Test
    public void testLoginLogout() throws MalformedURLException, URISyntaxException {
        // Configuration du driver Appium
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("/home/davila/testapps/mickmaq-api-testing/testapp/mickmaq/src/test/java/ressource/app-release.apk");
        options.setDeviceName("devicemickmaq");
        AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723/wd/hub").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        try {
            // Navigation dans l'application
            driver.findElement(By.className("android.widget.ImageView")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"English\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Continue\"]")).click();
		driver.findElement(By.className("android.widget.ImageView")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Cameroon\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Continue\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Skip\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofNanos(5)); // Délai d'attente augmenté

	        // Essayer de cliquer sur le bouton d'autorisation
	        try {
	            System.out.println("Essai de trouver le bouton d'autorisation...");
	            WebElement permissionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")));
	            permissionButton.click();
	        } catch (TimeoutException e) {
	            System.out.println("Le bouton d'autorisation n'est pas visible, continuation des tests.");
	        } 
	        // Continuer avec le reste des tests
	        try {
	           // System.out.println("Essai de cliquer sur 'Shop on Mickmaq'...");
	            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Shop on Mickmaq\"]")).click();
	            driver.findElement(By.xpath("(//com.horcrux.svg.PathView)[1]")).click();
	           // System.out.println("Essai de cliquer sur 'Sign Up or Sign in'...");
	            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Sign Up or Sign in\"]")).click();
	            
	          //  System.out.println("Essai de cliquer sur 'Login'...");
	            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Login\"]")).click();
	            //System.out.println("Essai d'entrer l'email...");
	            driver.findElement(By.xpath("//android.widget.EditText[@text=\"Please enter email\"]")).sendKeys("saheiresseiddu-4280@yopmail.com");
	            
	            //System.out.println("Essai d'entrer le mot de passe...");
	            driver.findElement(By.xpath("//android.widget.EditText[@text=\"Please enter password\"]")).sendKeys("Mickmaq106#");
	            driver.findElement(By.xpath( "//android.widget.TextView[@text=\"Continue\"]")).click();
	            driver.findElement(By.xpath("//android.widget.TextView[@text=\"See more\"]")).click();
	    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	        }catch (Exception e) {
		System.out.println("fin!!");
			}
           } finally {
            driver.quit(); // Fermer le driver Appium
        }
    }
}
