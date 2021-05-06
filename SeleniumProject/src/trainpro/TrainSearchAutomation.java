package trainpro;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.reporters.Files;
import org.testng.Assert;




public class TrainSearchAutomation {
	static String Browser;
    static WebDriver driver;
    static ArrayList<String> rowValues =new ArrayList<String>();
  /*  public static void Test()
	{

		for(String strVal : rowValues) {
			System.out.println("Browser:" +strVal);
		
		}
		
			
		} */
   
    
	public static void initializeBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
              ChromeOptions co = new ChromeOptions();
	
         	 //disable notifications
	         co.addArguments("--disable-notifications");           
	
          	//Initiate PageLoad Strategy
	        co.setPageLoadStrategy(PageLoadStrategy.EAGER);   
          	co.addArguments("--disable-infobars");
	
         	//WebDriver location
         	System.setProperty("webdriver.chrome.driver","C:\\Users\\910602\\eclipse-workspace\\first selinium\\DRIVER\\chromedriver.exe");
	
	        //Invoke Chrome Driver
             driver=new ChromeDriver(co);
            /* String baseUrl = "https://www.irctc.co.in/";   
	 			//Maximize the window
	 			driver.manage().window().maximize();
	 			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	 			driver.findElement(By.xpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button")).click(); */
		}
		if(browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions fo = new FirefoxOptions();
			
			//disable notifications
			fo.addArguments("--disable-notifications");           
			
			//Initiate PageLoad Strategy
			fo.setPageLoadStrategy(PageLoadStrategy.EAGER);       
			fo.addArguments("--disable-infobars");
			
			//WebDriver location
			System.setProperty("webdriver.gecko.driver","C:\\Users\\910602\\eclipse-workspace\\first selinium\\DRIVER\\geckodriver.exe");
			
			//Invoke firefox driver
			driver=new FirefoxDriver(fo);	
			
		}
		/* else {
			System.out.println("Invalid browser");
		}
		return driver; */
	}
	public void verify(WebDriver driver) throws InterruptedException, IOException {	
		
		//Assign Irctc webpage link to a variable
		String baseUrl = "https://www.irctc.co.in/"; 
		//Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		//Opening the website
		driver.get(baseUrl);
				
	
	
	//Getting the opened website title 
	String PageTitle=driver.getTitle();
	Assert.assertEquals(PageTitle,"IRCTC Next Generation eTicketing System");
	
	//Accept Alert
	driver.findElement(By.xpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button")).click();	
		
	} 

      public void fromcity() throws InterruptedException
      {
    	  driver.findElement(By.xpath("//*[@id=\'origin\']/span/input")).click();  
  		driver.findElement(By.xpath("//*[@id=\'origin\']/span/input")).sendKeys("Hyd");
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("//*[@id=\'origin\']/span/input")).sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
  		Thread.sleep(2000);
      }
       
     /* public void selectdate()
      {
    	//Choose future date as 4 days from current date
  		WebElement date = driver.findElement(By.xpath("//*[@id='jDate']/span/input")); 
  		date.sendKeys(Keys.CONTROL, Keys.chord("a")); //select all text in textbox
  		date.sendKeys(Keys.BACK_SPACE); //delete it
  		
  		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
  	    Calendar now = Calendar.getInstance(); // gets current date
  	    now.add(Calendar.DATE, 4);             // add four days
  	    String firstDate = dateFormat.format(now.getTime());
  	    driver.findElement(By.xpath("//*[@id='jDate']/span/input")).sendKeys(firstDate);
      }  */
      public void tocity() throws InterruptedException
      {
    	//Enter destination
  		driver.findElement(By.xpath("//*[@id=\'destination\']/span/input")).sendKeys("Pune"); 
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("//*[@id=\'destination\']/span/input")).sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
  		Thread.sleep(2000);
      }
 
  		public void selectdate()
  		{
  	//Choose future date as 4 days from current date
  		WebElement date = driver.findElement(By.xpath("//*[@id='jDate']/span/input")); 
  		date.sendKeys(Keys.CONTROL, Keys.chord("a")); //select all text in textbox
  		date.sendKeys(Keys.BACK_SPACE); //delete it
  		
  		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
  	    Calendar now = Calendar.getInstance(); // gets current date
  	    now.add(Calendar.DATE, 4);             // add four days
  	    String firstDate = dateFormat.format(now.getTime());
  	    driver.findElement(By.xpath("//*[@id='jDate']/span/input")).sendKeys(firstDate);
  	  date.sendKeys(Keys.ENTER);
      }//*[@id="jDate"]/span/input*/
     
      
      public void selectclass() throws InterruptedException
      {
    	  driver.findElement(By.id("journeyClass")).click(); 
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id='journeyClass']/div/div[4]/div/ul/p-dropdownitem[10]/li")).click();
	    Thread.sleep(2000);

  	    
      }
      
      public void checkbox() throws InterruptedException
      {
    	  driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div/div/div[1]/div[1]/div[1]/app-jp-input/div/form/div[4]/div/span[1]/label")).click();
          Thread.sleep(2000);
          
          driver.findElement(By.xpath("/html/body/app-root/app-home/div[3]/div/app-main-page/div/div/div[1]/div[1]/div[1]/app-jp-input/p-confirmdialog/div/div/div[3]/button")).click();
  	    Thread.sleep(2000);
  	     
      }
      
      public void findtrain()
      {
    	  driver.findElement(By.xpath("/html/body/app-root/app-home/div[3]/div/app-main-page/div/div/div[1]/div[1]/div[1]/app-jp-input/div/form/div[5]/div/button")).click();
      }

      public void searchresult() throws InterruptedException
      {
    	//Navigate to Search Result Window
  	    Thread.sleep(5000);
  	    String search=driver.getWindowHandle();
  	    driver.switchTo().window(search);
      }
      
      public void trainresult() throws InterruptedException
      { //Print Number of train search results available
  	    String Trains=driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-train-list/div[4]/div/div[1]")).getText();
  	    System.out.println(Trains);
  	    Thread.sleep(2000);
      }
      
      public void trainnames()
      {
    	 
    //Print the names of the trains
	    String[] results=driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-train-list/div[4]/div/div[1]/span")).getText().split(" ");
		String f=results[0];
		List<WebElement> trainList=driver.findElements(By.xpath("//div[contains(@class,'train-heading')]/strong"));
		int i=1;
		System.out.println("Total Number of trains available are :"+f+"\n");
		for (WebElement train:trainList)
		{
			System.out.println(i +":"+ train.getText()+"\n");
			i++;
		}
      }
      
    //capturing screenshot Method
      public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception
      {
    	 
    		   //Convert web driver object to TakeScreenshot

    		 TakesScreenshot scrShot =((TakesScreenshot)webdriver);

    		 //Call getScreenshotAs method to create image file

    		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

    		//Move image file to new destination

    		 File DestFile=new File(fileWithPath);

    		 //Copy file at destination

    		 FileUtils.copyFile(SrcFile, DestFile);

      }
      public void close() throws Exception
      {
    	  takeSnapShot(driver, "C:\\Users\\910602\\Pictures\\projectscreenshot\\screenshot.png");
    	//Quit Driver and Close the WebPage
  		driver.quit();       
      }
      
      public static  void getTestData() throws IOException{
			FileInputStream fls=new FileInputStream("C:\\Users\\910602\\eclipse-workspace\\SeleniumProject\\Excel\\Testdata.xlsx");
			try(XSSFWorkbook workbook = new XSSFWorkbook(fls)){
				XSSFSheet sheet=workbook.getSheetAt(0);
				int n=sheet.getLastRowNum();
				for(int j=1;j<=n;j++) {
					String val=(sheet.getRow(j).getCell(0).getStringCellValue());
				
					rowValues.add(val);
				}}
			}
      public static void main(String[] args) throws Exception
      {

			
TrainSearchAutomation pro=new  TrainSearchAutomation();
   
    		 getTestData();
             for (String strVal : rowValues)
             {
                 System.out.println("Browser:" + strVal);
                 initializeBrowser(strVal);
    	//pro.invokebrowser();
    pro.verify(driver);
       //pro.getURL();
      // pro.addremove();
       pro.fromcity();
       pro.tocity();
       pro.selectdate();
     pro.selectclass();
       pro.checkbox();
   pro.findtrain();
     // pro.searchresult();
       //pro.trainnames();
       pro.close();
      }
}
}
