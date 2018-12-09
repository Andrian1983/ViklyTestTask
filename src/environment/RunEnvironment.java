package environment;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RunEnvironment {
	private static WebDriver webDriver;

	public static WebDriver getWebDriver() {
		return webDriver;
	}

	static void setWebDriver(WebDriver webDriver) {
		RunEnvironment.webDriver = webDriver;
	}

	public void GoToPage(String PageURL) {

		webDriver.get(PageURL);
	}

	// Changing language

	@Test
	public void ChangeDevision(String Devision) {

		WebElement englanguage = webDriver.findElement(By.className(Devision));

		englanguage.click();

	}

	@Test
	public void FindElementBycssSelector(String locator) throws InterruptedException {

		WebElement CssSelectorElement = webDriver.findElement(By.cssSelector(locator));
		CssSelectorElement.click();

		Thread.sleep(4000);

	}

	@Test
	public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File SrcFile = (File) scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}

	// Selection the calendar date of the first trip
	@Test
	public void CheckIn(String Data) {

		webDriver.findElement(By.cssSelector(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.h-page__navigation-check-avail.js-nav-check-avail.h-page__wrapper.show_title > div > form > div.check-form-wrapper.clearfix > div.check-form > div:nth-child(1) > div > span > span.input-icon > svg"))
				.click();

		List<WebElement> allDates = webDriver.findElements(By.xpath("//table[@class='month2']//td"));

		for (WebElement ele : allDates) {

			String date = ele.getText();

			if (date.equalsIgnoreCase(Data)) {
				ele.click();

				break;
			}

		}

		webDriver.findElement(By.cssSelector(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.h-page__navigation-check-avail.js-nav-check-avail.h-page__wrapper.show_title > div > form > div.check-form-wrapper.clearfix > div.check-form > div:nth-child(1) > div > span > span.input-icon > svg"))
				.click();

	}

	@Test
	public void CheckOut(String Data) {

		webDriver.findElement(By.cssSelector(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.h-page__navigation-check-avail.js-nav-check-avail.h-page__wrapper.show_title > div > form > div.check-form-wrapper.clearfix > div.check-form > div:nth-child(2) > div > span > span.input-icon > svg"))
				.click();

		List<WebElement> allDates = webDriver.findElements(By.xpath("//table[@class='month2']//td"));

		for (WebElement ele : allDates) {

			String date = ele.getText();

			if (date.equalsIgnoreCase(Data)) {
				ele.click();

				break;
			}

		}

	}

	@Test
	public void TypeInRoomsAndGuestField(String iAge1, String iAge2) throws InterruptedException {

		WebElement RoomsAndGuest = webDriver.findElement(By.cssSelector(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.h-page__navigation-check-avail.js-nav-check-avail.h-page__wrapper.show_title > div > form > div.check-form-wrapper.clearfix > div.check-form > div.check-date-wrapper.guests-select-wrapper.clearfix > div.check-input.basic-input.js-r-and-g-btn > span"));
		RoomsAndGuest.click();

		WebElement AdultPlus = webDriver.findElement(By.cssSelector(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.h-page__navigation-check-avail.js-nav-check-avail.h-page__wrapper.show_title > div > form > div.check-form-wrapper.clearfix > div.check-form > div.check-date-wrapper.guests-select-wrapper.clearfix > div.js-guest-module > div > div.js-select-room > div > div:nth-child(2) > div.adults-child-wrapper > div.adults-wrapper > div.js-add-block.adults-child-btn > div.js-add.btn-add"));
		AdultPlus.click();

		// Some problem with functionalities in adding year of children into combobox

		WebElement BabyPlus = webDriver.findElement(By.cssSelector(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.h-page__navigation-check-avail.js-nav-check-avail.h-page__wrapper.show_title > div > form > div.check-form-wrapper.clearfix > div.check-form > div.check-date-wrapper.guests-select-wrapper.clearfix > div.js-guest-module > div > div.js-select-room > div > div:nth-child(2) > div.adults-child-wrapper > div.children-wrapper > div.js-add-block.adults-child-btn > div.js-add.btn-add"));

		BabyPlus.click();

		Thread.sleep(2000);

		WebElement BabyPlus1 = webDriver.findElement(By.cssSelector(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.h-page__navigation-check-avail.js-nav-check-avail.h-page__wrapper.show_title > div > form > div.check-form-wrapper.clearfix > div.check-form > div.check-date-wrapper.guests-select-wrapper.clearfix > div.js-guest-module > div > div.js-select-room > div > div:nth-child(2) > div.adults-child-wrapper > div.children-wrapper > div.js-add-block.adults-child-btn > div.js-add.btn-add"));

		Thread.sleep(2000);

		// Locate 'Programming Languages' dropdown using id WebElement progLanguages
		webDriver.findElement((By.cssSelector(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.h-page__navigation-check-avail.js-nav-check-avail.h-page__wrapper.show_title > div > form > div.check-form-wrapper.clearfix > div.check-form > div.check-date-wrapper.guests-select-wrapper.clearfix > div.js-guest-module > div > div.js-select-room > div > div:nth-child(2) > div.js-child-age-container.child-age-wrapper > div.js-select-container > select:nth-child(1)")));

		WebElement select = webDriver.findElement((By.cssSelector(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.h-page__navigation-check-avail.js-nav-check-avail.h-page__wrapper.show_title > div > form > div.check-form-wrapper.clearfix > div.check-form > div.check-date-wrapper.guests-select-wrapper.clearfix > div.js-guest-module > div > div.js-select-room > div > div:nth-child(2) > div.js-child-age-container.child-age-wrapper > div.js-select-container > select:nth-child(1)")));

		List<WebElement> allOptions = select.findElements(By.tagName("option"));
		for (WebElement option : allOptions) {
			if (iAge1.equals(option.getText())) {
				System.out.println(String.format("Value is: %s", option.getAttribute("value")));
				option.click();
			}
		}

		BabyPlus1.click();

		WebElement select1 = webDriver.findElement((By.cssSelector(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.h-page__navigation-check-avail.js-nav-check-avail.h-page__wrapper.show_title > div > form > div.check-form-wrapper.clearfix > div.check-form > div.check-date-wrapper.guests-select-wrapper.clearfix > div.js-guest-module > div > div.js-select-room > div > div:nth-child(2) > div.js-child-age-container.child-age-wrapper > div.js-select-container > select:nth-child(2)")));

		List<WebElement> allOptions1 = select1.findElements(By.tagName("option"));
		for (WebElement option : allOptions1) {
			if (iAge2.equals(option.getText())) {
				System.out.println(String.format("Value is: %s", option.getAttribute("value")));
				option.click();
			}
		}

		RoomsAndGuest.click();

	}

	@Test
	public void assertion_Guest_inRoom(String sExpectedGuests, String sExpectedRooms) {

		String sActualGuests = webDriver.findElement(By.cssSelector(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.h-page__navigation-check-avail.js-nav-check-avail.h-page__wrapper.show_title > div > form > div.check-form-wrapper.clearfix > div.check-form > div.check-date-wrapper.guests-select-wrapper.clearfix > div.check-input.basic-input.js-r-and-g-btn > span > span.js-guest-count.guest-count > span"))
				.getText();

		Assert.assertEquals(sActualGuests, sExpectedGuests);

		String sActualRooms = webDriver.findElement(By.cssSelector(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.h-page__navigation-check-avail.js-nav-check-avail.h-page__wrapper.show_title > div > form > div.check-form-wrapper.clearfix > div.check-form > div.check-date-wrapper.guests-select-wrapper.clearfix > div.check-input.basic-input.js-r-and-g-btn > span > span.js-rooms-count.rooms-count"))
				.getText();

		String[] sActualRoomsData = sActualRooms.split(" ");

		String sActualRoomsNumber = sActualRoomsData[0];

		Assert.assertEquals(sActualRoomsNumber, sExpectedRooms);

	}

	@Test
	public void SelectTheRoom(String locator) throws InterruptedException {

		String parent = webDriver.getWindowHandle();

		WebElement CssSelectorAllPricesButton = webDriver.findElement(By.cssSelector(locator));

		CssSelectorAllPricesButton.submit();

		Thread.sleep(4000);

		Set<String> s1 = webDriver.getWindowHandles();

		int count = s1.size();

		System.out.println("Total window = " + count);

		for (String child : s1) {
			if (!parent.equalsIgnoreCase(child)) {
				webDriver.switchTo().window(child);
				Thread.sleep(3000);
			}
		}

	}

	@Test
	public void BookingTheRoom(String locator) throws InterruptedException {

		WebElement CssSelectorElement = webDriver.findElement(By.cssSelector(locator));
		CssSelectorElement.click();

	}

	@Test
	public void assertionReservationRoom(String sExpectedCheckIn, String sExpectedCheckOut, String sExpectedGuests) {

		String sActualCheckIn = webDriver.findElement(By.cssSelector(
				"#container > div.book__content-additional > div.book-wrap__book_info > div.booked__book-info > div.book-info__hotel > div > div.book-info__blank.room-info-blank-mobile > div.room-info-wrap.check-date.check-in > span.data-row.room-info-data.month-day"))
				.getText();

		Assert.assertEquals(sActualCheckIn, sExpectedCheckIn);

		String sActualCheckOut = webDriver.findElement(By.cssSelector(
				"#container > div.book__content-additional > div.book-wrap__book_info > div.booked__book-info > div.book-info__hotel > div > div.book-info__blank.room-info-blank-mobile > div.room-info-wrap.check-date.check-out > span.data-row.room-info-data.month-day"))
				.getText();

		Assert.assertEquals(sActualCheckOut, sExpectedCheckOut);
		List<WebElement> sActualExpectedGuests = webDriver.findElements(By.cssSelector(
				"html#ng-app body.page_book.lngcode_ru.secure-site.js-secure-site.js-fixed-body.no-touch div#page-wrapper div#container.container.booking-page.book-flights.clearfix div.book__content-body.ab-test div.booked_iframe-wrap.js-to-scroll-target div form#booking_form.js-to-scroll-target div div.content-page-blank div.book-page__person.js-book-page__person"));

		String sActualExpectedGuestsValue = Integer.toString(sActualExpectedGuests.size());

		Assert.assertEquals(sActualExpectedGuestsValue, sExpectedGuests);

	}

}
