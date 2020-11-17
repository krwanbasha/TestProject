package listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import tests.TestBase;

public class TestAllureListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		saveScreenshotOnFailure(TestBase.getDriver());
		saveLogs(result.getMethod().getConstructorOrMethod().getName());
	}

	@Attachment(value = "Stacktrace", type = "text/plain")
	private static String saveLogs(String message) {
		return message;
	}

	@Attachment(value = "Screenshot", type = "image/png")
	private byte[] saveScreenshotOnFailure(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}
