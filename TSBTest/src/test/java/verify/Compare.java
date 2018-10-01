package verify;

import org.openqa.selenium.WebDriver;

public class Compare {

		public static boolean  validateURL(WebDriver driver , String expURL)
		{
			boolean result = false;
			if(driver.getCurrentUrl().equalsIgnoreCase(expURL))
			{
				result=false;
			
			}
			
			return result;
			
		}
}
