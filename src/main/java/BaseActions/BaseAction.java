package BaseActions;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;

public class BaseAction {
	public static WebDriver driver;
	public static boolean driverLaunched = false;
	public static FileReader inputReader;
	public static Properties scenarioInput;

	public Properties loadScenarioInput(String file) {
		try {
			inputReader = new FileReader(file);
			scenarioInput = new Properties();
			scenarioInput.load(inputReader);
			return scenarioInput;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
