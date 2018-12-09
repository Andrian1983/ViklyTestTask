package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
//import tests.Helper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DemoTest {

	@Before
	public void startBrowser() {
		EnvironmentManager.initWebDriver();
	}

	@Test
	public void ViklyTest() throws Exception {

		String browser = "chrome";

		String MainUrl = "https://knickerbocker-hotel-new-york.nochi.com/?btest=119";

		RunEnvironment UIpage = new RunEnvironment();

		// Launching of browser
		//UIpage.LaunchBrowser(browser);

		UIpage.GoToPage(MainUrl);

		UIpage.FindElementBycssSelector(
				"#container > div > div > div > div.h-page__gallery.js-hotel-gallery.js-gallery-wrapper.clearfix > div.gallery-left-column > div.image-container.js-gtm-main-gallery.image-width-small.js-nav-menu > div > div");

		UIpage.FindElementBycssSelector(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.fixed-navbar-container > div > div > ul > li.nav-item.js-gtm-nav-item-overview > a");

		UIpage.takeSnapShot(UIpage.getWebDriver(), "E://Selenium_images//Description.png");

		UIpage.FindElementBycssSelector(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.fixed-navbar-container > div > div > ul > li.nav-item.js-gtm-nav-item-facilities > a");

		UIpage.takeSnapShot(UIpage.getWebDriver(), "E://Selenium_images//convenience.png");

		UIpage.FindElementBycssSelector(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.fixed-navbar-container > div > div > ul > li.nav-item.js-gtm-nav-item-rooms > a");

		UIpage.takeSnapShot(UIpage.getWebDriver(), "E://Selenium_images//rooms.png");

		UIpage.FindElementBycssSelector(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.fixed-navbar-container > div > div > ul > li.nav-item.js-gtm-nav-item-location.js-nav-item-location > a");

		UIpage.takeSnapShot(UIpage.getWebDriver(), "E://Selenium_images//Location.png");

		UIpage.FindElementBycssSelector(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.fixed-navbar-container > div > div > ul > li.nav-item.js-gtm-nav-item-reviews.js-nav-item-reviews > a");
		UIpage.takeSnapShot(UIpage.getWebDriver(), "E://Selenium_images//reviews.png");

		UIpage.CheckIn("24");

		UIpage.CheckOut("25");

		UIpage.TypeInRoomsAndGuestField("2", "10");

		UIpage.assertion_Guest_inRoom("5", "1");

		UIpage.takeSnapShot(UIpage.getWebDriver(), "E://Selenium_images//RentRoom.png");

		UIpage.SelectTheRoom(
				"#container > div > div > div > div.h-page__body.clearfix.ng-scope > div.fixed-navbar.js-fixed-navbar > div.h-page__navigation-check-avail.js-nav-check-avail.h-page__wrapper.show_title > div > form > div.check-form-wrapper.clearfix > div.get-price > div > div._btn-check-wrapper > button.basic-btn.__btn-check.show-tablet.js-get-price-btn.js-gtm-check-avail-btn");

		UIpage.BookingTheRoom(
				"div[id^='hotel-'] > div.flight-deck-rooms.clearfix.ng-scope > div.ng-scope > div > div > div > div.room-blank__rates > div:nth-child(2) > div.book-now-btn_wrapper > button");

		UIpage.takeSnapShot(UIpage.getWebDriver(), "E://Selenium_images//RoomForRent.png");

		UIpage.assertionReservationRoom("24", "25", "5");
	}

	@After
	public void tearDown() {
		EnvironmentManager.shutDownDriver();
	}

}
