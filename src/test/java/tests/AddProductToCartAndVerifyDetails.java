package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCartAndVerifyDetails {

    @Test
    public void addProductToCartAndVerifyDetailsTest(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        WebElement userPasswordField = driver.findElement(By.id("password"));
        userPasswordField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addToCartButton.click();
        WebElement shoppingCartButton = driver.findElement(By.cssSelector(".shopping_cart_link"));
        shoppingCartButton.click();
        String actualPrice = driver.findElement(By.xpath("//*[text()=\"9.99\"]")).getText();
        Assert.assertTrue(actualPrice.contains("9.99"));
        String actualProductName = driver.findElement(By.cssSelector("[data-test=\"inventory-item-name\"]")).getText();
        Assert.assertEquals(actualProductName, "Sauce Labs Bike Light");



    }
}
