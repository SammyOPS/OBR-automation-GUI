import java.io.*;
import java.util.*;
import java.text.*;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.*;

import org.testng.*;

public class ScreenshotListener extends TestListenerAdapter {
    WebDriver driver;
    @Override
    public void onTestFailure(ITestResult result) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName = result.getName();
        if(!result.isSuccess()){
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/surefire-reports";
                File destFile = new File((String) reportDirectory+"/failure_screenshots/"+methodName+"_"+formater.format(calendar.getTime())+".png");
                FileUtils.copyFile(scrFile, destFile);
                Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    public void onTestFailure(ITestResult arg0) {
//        try {
//            File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(file, new File(System.getProperty("user.dir")+File.separator +
//                    arg0.getName()+"_"+arg0.getEndMillis()+".png"));
//            System.out.println("*******Screenshot captured********" + System.getProperty("user.dir")+File.separator +
//                    arg0.getName()+"_"+arg0.getEndMillis()+".png");
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
}