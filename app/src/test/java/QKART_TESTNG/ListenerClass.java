package QKART_TESTNG;

import org.testng.ITestContext;  
import org.testng.ITestListener;  
import org.testng.ITestResult;  
  
public class ListenerClass implements ITestListener   
{  
  
    @Override  
    public void onTestStart(ITestResult result) {  
        // TODO Auto-generated method stub  
        System.out.println("Start of test cases and its details are : "+result.getName()); 
        QKART_Tests.takeScreenshot("TestStart",result.getName());
    }  
  
    @Override  
    public void onTestSuccess(ITestResult result) {  
        // TODO Auto-generated method stub  
        System.out.println("Success of test cases and its details are : "+result.getName());  
        QKART_Tests.takeScreenshot("TestSuccess",result.getName());
    }  
  
    @Override  
    public void onTestFailure(ITestResult result) {  
        // TODO Auto-generated method stub  
        System.out.println("Failure of test cases and its details are : "+result.getName());  
        QKART_Tests.takeScreenshot("TestFailure",result.getName());
    }  
  
    @Override  
    public void onTestSkipped(ITestResult result) {  
        // TODO Auto-generated method stub  
        System.out.println("Skip of test cases and its details are : "+result.getName());  
    }  
  
    @Override  
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
        // TODO Auto-generated method stub  
        System.out.println("Failure of test cases and its details are : "+result.getName());  
    }  
  
    @Override  
    public void onStart(ITestContext context) {  
        // TODO Auto-generated method stub  
          
    }  
  
    @Override  
    public void onFinish(ITestContext context) {  
        // TODO Auto-generated method stub  
          
    }  
}  