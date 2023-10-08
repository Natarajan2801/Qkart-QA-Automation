package QKART_SANITY_LOGIN.Module1;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResult {
    WebElement parentElement;

    public SearchResult(WebElement SearchResultElement) {
        this.parentElement = SearchResultElement;
    }

    /*
     * Return title of the parentElement denoting the card content section of a
     * search result
     */
    public String getTitleofResult() throws InterruptedException {
        String titleOfSearchResult = " ";
        // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 03: MILESTONE 1
        // Find the element containing the title (product name) of the search result and
        // assign the extract title text to titleOfSearchResult
       //div[contains(@class,'MuiCardContent-root')]/p[contains(@class,'css-yg30e6')]
       //
        Thread.sleep(2000);
        WebElement titleElement = parentElement.findElement(By.xpath(".//p[@class ='MuiTypography-root MuiTypography-body1 css-yg30e6']"));
        //*[@id="root"]/div/div/div[3]/div/div[2]/div/div/div[1]/p[1]
        titleOfSearchResult = titleElement.getText();
     return titleOfSearchResult;
    }



    /*
     * Return Boolean denoting if the open size chart operation was successful
     */

    public Boolean openSizechart() {
        try {

            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 04: MILESTONE 2
            // Find the link of size chart in the parentElement and click on it
            parentElement.findElement(By.xpath("//button[text()='Size chart']")).click();
            return true;
        } catch (Exception e) {
            System.out.println("Exception while opening Size chart: " + e.getMessage());
            return false;
        }
    }

    /*
     * Return Boolean denoting if the close size chart operation was successful
     */
    public Boolean closeSizeChart(WebDriver driver) {
        try {
            Thread.sleep(2000);
            Actions action = new Actions(driver);

            // Clicking on "ESC" key closes the size chart modal
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            Thread.sleep(2000);
            return true;
        } catch (Exception e) {
            System.out.println("Exception while closing the size chart: " + e.getMessage());
            return false;
        }
    }

    /*
     * Return Boolean based on if the size chart exists
     */
    public Boolean verifySizeChartExists() {
        Boolean status = false;
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 04: MILESTONE 2
            /*
             * Check if the size chart element exists. If it exists, check if the text of
             * the element is "SIZE CHART". If the text "SIZE CHART" matches for the
             * element, set status = true , else set to false
             */
            //button[text()='Size chart']
            // Thread.sleep(2000);
            // status= parentElement.findElement(By.xpath("//button[text()='SIZE CHART']")).isDisplayed();
            WebElement element = parentElement.findElement(By.tagName("button"));
            status = element.getText().equals("SIZE CHART");
            return status;
            
        } catch (Exception e) {
            System.out.print("*****"+e.getMessage());
            return status;
        }
    }

    /*
     * Return Boolean if the table headers and body of the size chart matches the
     * expected values
     */
    public Boolean validateSizeChartContents(List<String> expectedTableHeaders, List<List<String>> expectedTableBody,
            WebDriver driver) {
        Boolean status = true;
        List<WebElement> header=new ArrayList<>();
        List<WebElement> body=new ArrayList<>();
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 04: MILESTONE 2
            /*
             * Locate the table element when the size chart modal is open
             * 
             * Validate that the contents of expectedTableHeaders is present as the table
             * header in the same order
             * 
             * Validate that the contents of expectedTableBody are present in the table body
             * in the same order
             */
            Thread.sleep(1000);
            header=driver.findElements(By.xpath("//table/thead/tr/th"));
            for(int i=0;i<expectedTableHeaders.size();i++){
                String check=header.get(i).getText();
                if(!check.equalsIgnoreCase(expectedTableHeaders.get(i))){
                        return false;
                }
            }
            int k=0;
            Thread.sleep(1000);
            body=driver.findElements(By.xpath("//table/tbody/tr/td"));
            for(int i=0;i<expectedTableBody.size();i++){
                
                for(int j=0;j<expectedTableBody.get(0).size();j++){
                  //  System.out.print(ex.get(i).get(j)+" ");
                  String check=body.get(k++).getText();
                    if(!check.equalsIgnoreCase(expectedTableBody.get(i).get(j))){
                        return false;
                    }
                }
                //  System.out.println();
            }
            return status;

        } catch (Exception e) {
            System.out.println("Error while validating chart contents");
            return false;
        }
    }

    /*
     * Return Boolean based on if the Size drop down exists
     */
    public Boolean verifyExistenceofSizeDropdown(WebDriver driver) {
        Boolean status = false;
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 04: MILESTONE 2
            // If the size dropdown exists and is displayed return true, else return false
            WebElement dropdown = driver.findElement(By.xpath("//select"));
            status=dropdown.isDisplayed();
            return status;
        } catch (Exception e) {
            return status;
        }
    }
}