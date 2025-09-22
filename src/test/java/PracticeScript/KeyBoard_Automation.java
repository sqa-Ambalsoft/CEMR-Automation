package PracticeScript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyBoard_Automation {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		Robot r = new Robot();
		
//		r.keyPress(KeyEvent.VK_CAPS_LOCK);
//		
//		r.keyRelease(KeyEvent.VK_CAPS_LOCK);
//		Thread.sleep(2000);
//		r.keyPress(KeyEvent.VK_CAPS_LOCK);
//		
//		r.keyRelease(KeyEvent.VK_CAPS_LOCK);
		
		r.keyPress(KeyEvent.VK_ALT);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(500);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(500);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(500);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(500);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(500);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(500);
		r.keyRelease(KeyEvent.VK_ALT);
		
	}
}
