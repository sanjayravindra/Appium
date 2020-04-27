package com.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calculator {
	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		System.out.println("aumation started");
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
	dc.setCapability("appPackage", "com.android.calculator2");
	dc.setCapability("appActivity", "com.android.calculator2.Calculator");
	System.out.println("start");
	
URL url = new URL("http://127.0.0.1:4723/wd/hub");
System.out.println("Connected to sever");
AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url,dc);
System.out.println("driver is started");

Thread.sleep(5000);
System.out.println("sleep");

//driver.findElement(By.id("com.google.android.apps.nexuslauncher:id/clock")).click();


driver.findElement(By.id("com.android.calculator2:id/digit_6")).click();
driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
driver.findElement(By.id("com.android.calculator2:id/digit_4")).click();
driver.findElement(By.id("com.android.calculator2:id/eq")).click();
Thread.sleep(3000);
String result = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
System.out.println(result);

if(result.equals("10"))
{
	System.out.println("Test Passed...");
}
else
{
	System.out.println("Test Failed...");
}

	}
}
