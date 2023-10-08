package QKART_SANITY_LOGIN.Module1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout {
    RemoteWebDriver driver;
    String url = "https://crio-qkart-frontend-qa.vercel.app/checkout";

    public Checkout(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void navigateToCheckout() {
        if (!this.driver.getCurrentUrl().equals(this.url)) {
            this.driver.get(this.url);
        }
    }

    /*
     * Return Boolean denoting the status of adding a new address
     */
    public Boolean addNewAddress(String addresString) {
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 05: MILESTONE 4
            /*
             * Click on the "Add new address" button, enter the addressString in the address
             * text box and click on the "ADD" button to save the address
             */
            driver.findElement(By.xpath("//button[text()='Add new address']")).click();
           // Thread.sleep(2000);
            driver.findElement(By.xpath("//textarea")).sendKeys(addresString);
           // Thread.sleep(2000);
            driver.findElement(By.xpath("//button[text()='Add']")).click();
           // Thread.sleep(2000);
            return false;
        } catch (Exception e) {
            System.out.println("Exception occurred while entering address: " + e.getMessage());
            return false;

        }
    }

    /*
     * Return Boolean denoting the status of selecting an available address
     */
    public Boolean selectAddress(String addressToSelect) {
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 05: MILESTONE 4
            /*
             * Iterate through all the address boxes to find the address box with matching
             * text, addressToSelect and click on it
             */
            List<WebElement> listAddress= driver.findElements(By.xpath("//div[contains(@class,'address-item')]"));
            String xpath="//p[text()='"+addressToSelect+"']";
            for(WebElement l : listAddress){
                String check=l.findElement(By.xpath(xpath)).getText();
                    if(addressToSelect.contains(check)){
                        l.findElement(By.xpath("//input")).click();
                        break;
                    }else{
                        System.out.println("Unable to find the given address");
                        return false;
                    }
            }

            return true;

           
        } catch (Exception e) {
            System.out.println("Exception Occurred while selecting the given address: " + e.getMessage());
            return false;
        }

    }

    /*
     * Return Boolean denoting the status of place order action
     */
    public Boolean placeOrder() {
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 05: MILESTONE 4
            // Find the "PLACE ORDER" button and click on it
            driver.findElement(By.xpath("//button[text()='PLACE ORDER']")).click();
            return true;

        } catch (Exception e) {
            System.out.println("Exception while clicking on PLACE ORDER: " + e.getMessage());
            return false;
        }
    }

    /*
     * Return Boolean denoting if the insufficient balance message is displayed
     */
    public Boolean verifyInsufficientBalanceMessage() {
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 07: MILESTONE 6
           String check= driver.findElement(By.xpath("//*[@id='notistack-snackbar']")).getText();
          // System.out.print(check);
           if(check.contains("You do not have enough balance in your wallet for this purchase"))
            return true;
            else 
            return false;
        } catch (Exception e) {
            System.out.println("Exception while verifying insufficient balance message: " + e.getMessage());
            return false;
        }
    }

    public Boolean checkIframe(RemoteWebDriver driver) throws InterruptedException {
        String curURL=driver.getCurrentUrl();
        Boolean status=false;
       int num=driver.findElements(By.xpath("//iframe")).size();
       if(num!=3){
            System.out.println("Test Case 11: Fail For Iframe Scenario");
            return false;
       }
       driver.switchTo().frame(0);
       driver.findElement(By.xpath("//button[text()='View Cart']")).click();
       driver.switchTo().parentFrame();
       status=!curURL.equals(driver.getCurrentUrl());
      // driver.navigate().back();
    //driver.switchTo().frame(nameOrId)
        driver.get(curURL);
        Thread.sleep(3000);
      
       driver.switchTo().frame(1);
       driver.findElement(By.xpath("//button[text()='View Cart']")).click();
       driver.switchTo().parentFrame();
       status=!curURL.equals(driver.getCurrentUrl());
        driver.get(curURL);
      
        return status;
    }
}
