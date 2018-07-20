package chrome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class helloworld {
	
 
public static String driverPath = "F:/lib/chromedriver/";
 public static WebDriver driver;

 
 public static String[] replyMsg = {"Thanks a lot...","thanks for your wishes...","Like to have friendz like you...","Thanks To U...","Thanks a lot for taking time in sending me your warmest bday wishes! ","Allow me to take a minute of your time to say thank you for your warm bday wishes!",};

	public static void main(String []args) throws InterruptedException {
		System.out.println("launching chrome browser");
		openChrome();
		Thread.sleep(15000);
		openWhatsApp();
		
		
		//sleep for WAIT
		
		
		System.out.println("Continued ");
		
		
	}
	
	
	
    static void openChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Satin Gaux\\Downloads\\ZIP_folder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://web.whatsapp.com/");
		driver.manage().window().maximize();
	}
	
    static void openWhatsApp() {
    	String msgOld = "xxxxx";
    	String msgOld1 = "zzzzzz";
    	long count = 0;
    	while(true) {
    		try {
    			count++;
    			driver.findElement(By
    					.xpath("//DIV[@class='gQzdc']/../..//SPAN[@dir='auto'][text()='Happy Birthday Sachin bro']")).click();
    			WebElement selectedWindow = driver.findElement(By
						.xpath("//DIV[@class='_3oju3']/../..//DIV[@class='_9tCEa']"));
    			List<WebElement> msgList = selectedWindow.findElements(By
						.xpath("//SPAN[@dir='auto'][text()='Happy Birthday Sachin bro']/../../..//SPAN[@class='_2_LEW']"));
    			WebElement lastMsgDiv = msgList.get(msgList.size()-1);
				String msgCurrent = lastMsgDiv.getText();
				
				
				
				if( !msgOld.equals(msgCurrent) ) {
					
					System.out.println("Old Message :"+ msgOld);
					System.out.println("Current Message :"+msgCurrent);
					
					msgOld = msgCurrent;
					
					if(msgCurrent.contains("irthday")) {
						reply();
					}
				}else
					System.out.println("No CHANGE in I.T...");
				
				System.out.println("TRY COUNT :"+count);
				
				
				
				
				driver.findElement(By.xpath("(//DIV[@class='_2umId']/../..//SPAN[@dir='auto'])[1]")).click();
				WebElement selectedWindow1 = driver.findElement(By
						.xpath("//DIV[@class='_3oju3']/../..//DIV[@class='_9tCEa']"));
    			List<WebElement> msgList1 = selectedWindow1.findElements(By
						.xpath("(//SPAN[@dir='auto'])[1]/../../..//SPAN[@class='_2_LEW']"));
    			WebElement lastMsgDiv1 = msgList1.get(msgList.size()-1);
				String msgCurrent1 = lastMsgDiv1.getText();
				
				
				
				if( !msgOld1.equals(msgCurrent1) ) {
					
					System.out.println("Old Message :"+ msgOld1);
					System.out.println("Current Message :"+msgCurrent1);
					
					msgOld1 = msgCurrent1;
					
					if(msgCurrent1.contains("irthday")) {
						reply1();
					}
				}else
					System.out.println("No CHANGE in C.S...");
				
			
				
				Thread.sleep(5000);
				
				
    			
    		}catch(Exception e) {
    			System.out.println(e);
    		}
    	}
    }
	static void reply() {
		try {
		driver.findElement(By.xpath("//DIV[@class='_3oju3']//DIV[@class='_2S1VP copyable-text selectable-text']")).sendKeys(replyMsg[new Random().nextInt(replyMsg.length)]);
		driver.findElement(By.xpath("//DIV[@class='_3oju3']//SPAN[@data-icon='send']")).click();
		System.out.println("\n\n Message Thanku is successfully sended");
		}catch(Exception e) {
		System.out.println(e);}
	}
	static void reply1() {
		try {
		driver.findElement(By.xpath("//DIV[@class='_3oju3']//DIV[@class='_2S1VP copyable-text selectable-text']")).sendKeys(replyMsg[new Random().nextInt(replyMsg.length)]);
		driver.findElement(By.xpath("//DIV[@class='_3oju3']//SPAN[@data-icon='send']")).click();
		System.out.println("\n\n Message Thanku is successfully sended");
		}catch(Exception e) {
		System.out.println(e);}
	}
	
	
	

	
}