package QKART_SANITY_LOGIN.Module1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    RemoteWebDriver driver;
    String url = "https://crio-qkart-frontend-qa.vercel.app";

    public Home(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHome() {
        if (!this.driver.getCurrentUrl().equals(this.url)) {
            this.driver.get(this.url);
        }
    }

    public Boolean PerformLogout() throws InterruptedException {
        try {
            // Find and click on the Logout Button
            WebElement logout_button = driver.findElement(By.className("MuiButton-text"));
            logout_button.click();

            // SLEEP_STMT_10: Wait for Logout to complete
            // Wait for Logout to Complete
            Thread.sleep(1000);

            return true;
        } catch (Exception e) {
            // Error while logout
            return false;
        }
    }

    public Boolean MultipleWindowHandling(String PageName, RemoteWebDriver driver)
            throws InterruptedException {
       // String xpath = "//a[text()='" + PageName + "']";
      //  String check = driver.getCurrentUrl();
       // driver.findElement(By.xpath(xpath)).click();
       driver.findElement(By.linkText(PageName)).click();
        PageName=PageName.toLowerCase();
        String endingURL =PageName.split(" ")[0];
        String parent = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        driver.switchTo().window(s.toArray(new String[s.size()])[1]);
     //   System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        Boolean status=driver.getCurrentUrl().contains("https://crio-qkart-frontend-qa.vercel.app/"+endingURL);
        driver.close();
        driver.switchTo().window(s.toArray(new String[s.size()])[0]);
        //  driver.switchTo().window(parent);
        return status;
    }

    /*
     * Returns Boolean if searching for the given product name occurs without any errors
     */
    public Boolean searchForProduct(String product) {
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 03: MILESTONE 1
            // Clear the contents of the search box and Enter the product name in the search
            // box
            WebElement searchbox = driver.findElement(By.xpath("(//input[@name='search'])[1]"));
            searchbox.clear();
            searchbox.sendKeys(product);
            return true;
        } catch (Exception e) {
            System.out.println("Error while searching for a product: " + e.getMessage());
            return false;
        }
    }

    /*
     * Returns Array of Web Elements that are search results and return the same
     */
    public List<WebElement> getSearchResults() {
        List<WebElement> searchResults = new ArrayList<WebElement>();
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 03: MILESTONE 1
            // Find all webelements corresponding to the card content section of each of
            // search results
            // div[contains(@class,'MuiCardContent-root')]
            // div[contains(@class,'css-sycj1h')]
            Thread.sleep(2000);

            searchResults = driver
                    .findElements(By.xpath("  //div[contains(@class,'MuiCardContent-root')]"));

            return searchResults;
        } catch (Exception e) {
            System.out.println("There were no search results: " + e.getMessage());
            return searchResults;

        }
    }

    /*
     * Returns Boolean based on if the "No products found" text is displayed
     */
    public Boolean isNoResultFound() {

        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 03: MILESTONE 1
            // Check the presence of "No products found" text in the web page. Assign status
            // = true if the element is *displayed* else set status = false
            String check = driver.findElement(By.xpath("//h4")).getText();

            return check.contains("No products found") ? true : false;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * Return Boolean if add product to cart is successful
     */
    public Boolean addProductToCart(String productName) {
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 05: MILESTONE 4
            /*
             * Iterate through each product on the page to find the WebElement corresponding to the
             * matching productName
             * 
             * Click on the "ADD TO CART" button for that element
             * 
             * Return true if these operations succeeds
             */
            Thread.sleep(2000);
            List<WebElement> list =
                    driver.findElements(By.xpath(" //div[contains(@class,'css-sycj1h')]"));
            Boolean flag = true;
            for (WebElement l : list) {
                String check = l.getText();
                if (check.contains(productName)) {
                    l.findElement(By.xpath("//button[text()='Add to cart']")).click();
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Unable to find the given product");
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Exception while performing add to cart: " + e.getMessage());
            return false;
        }
    }

    /*
     * Return Boolean denoting the status of clicking on the checkout button
     */
    public Boolean clickCheckout() {
        Boolean status = false;
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 05: MILESTONE 4
            // Find and click on the the Checkout button
            driver.findElement(By.xpath("//button[text()='Checkout']")).click();
            return status;
        } catch (Exception e) {
            System.out.println("Exception while clicking on Checkout: " + e.getMessage());
            return status;
        }
    }

    /*
     * Return Boolean denoting the status of change quantity of product in cart operation
     */
    public Boolean changeProductQuantityinCart(String productName, int quantity) {
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 06: MILESTONE 5

            // Find the item on the cart with the matching productName

            // Increment or decrement the quantity of the matching product until the current
            // quantity is reached (Note: Keep a look out when then input quantity is 0,
            // here we need to remove the item completely from the cart)
            // div[contains(@class,'css-zgtx0t')]//div[text()='Xtend Smart Watch']
            // div[@data-testid='item-qty']
            // *[@data-testid='RemoveOutlinedIcon']
            // *[@data-testid='AddOutlinedIcon']
            // Thread.sleep(2000);
            // div[contains(@class,'css-1gjj37g')]

            List<WebElement> list =
                    driver.findElements(By.xpath("//div[contains(@class,'css-1gjj37g')]"));
            // String xpath="//div[text()='"+productName+"']";

            // div[contains(@class,'css-1gjj37g')]/div[1]
            for (int i = 0; i < list.size(); i++) {
                // String xpath="
                // //div[contains(@class,'css-zgtx0t')]//div[text()='"+productName+"']";
                // String
                // CheckName=driver.findElement(By.xpath("//div[contains(@class,'css-1gjj37g')]/div[1]")).getText();
                String CheckName =
                        driver.findElement(By.xpath("//*[@id='root']/div/div/div[3]/div[2]/div/div["
                                + (i + 1) + "]/div/div[2]/div[1]")).getText();


                if (CheckName.contains(productName)) {
                    String cur_quatitiy = driver
                            .findElement(By.xpath("//*[@id='root']/div/div/div[3]/div[2]/div/div["
                                    + (i + 1) + "]/div/div[2]/div[2]/div[1]/div"))
                            .getText();

                    // String cur_quatitiy=list.get(i).findElement(By.xpath("
                    // //div[@data-testid='item-qty']")).getText();

                    int current_quantity = Integer.parseInt(cur_quatitiy);

                    if (quantity > current_quantity) {
                        for (int j = current_quantity; j < quantity; j++) {
                            // String a="
                            // //*[@id="root"]/div/div/div[3]/div[2]/div/div["+i+1+"]/div/div[2]/div[2]/div[1]/button[2]";
                            WebElement incrementBtn = driver.findElement(
                                    By.xpath("//*[@id='root']/div/div/div[3]/div[2]/div/div["
                                            + (i + 1) + "]/div/div[2]/div[2]/div[1]/button[2]"));
                            incrementBtn.click();
                            Thread.sleep(2000);
                        }
                    } else if (quantity < current_quantity) {
                        for (int j = current_quantity; j > quantity; j--) {
                            WebElement decrementBtn = driver.findElement(
                                    By.xpath("//*[@id='root']/div/div/div[3]/div[2]/div/div["
                                            + (i + 1) + "]/div/div[2]/div[2]/div[1]/button[1]"));
                            decrementBtn.click();
                            Thread.sleep(2000);
                        }

                    }

                }

            }
            return true;
        } catch (Exception e) {
            if (quantity == 0)
                return true;
            System.out.println("exception occurred when updating cart: " + e.getMessage());
            return false;
        }



    }

    public Boolean verifyCartContents(List<String> expectedCartContents) {
        try {
            WebElement cartParent = driver.findElement(By.className("cart"));
            List<WebElement> cartContents = cartParent.findElements(By.className("css-zgtx0t"));

            ArrayList<String> actualCartContents = new ArrayList<String>() {};
            for (WebElement cartItem : cartContents) {
                actualCartContents.add(
                        cartItem.findElement(By.className("css-1gjj37g")).getText().split("\n")[0]);
            }

            for (String expected : expectedCartContents) {
                if (!actualCartContents.contains(expected)) {
                    return false;
                }
            }

            return true;

        } catch (Exception e) {
            System.out.println("Exception while verifying cart contents: " + e.getMessage());
            return false;
        }
    }
}
