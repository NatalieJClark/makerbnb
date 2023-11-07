package com.makers.makersbnb;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

class StaticPageTest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    public void usersAreWelcomedToTheApp() {
        page.navigate("localhost:8080");
        Locator pageH1 = page.locator("h1");
        assertThat(pageH1).containsText("Welcome to MakersBnB!");
        Locator pageH3 = page.locator("h3");
        assertThat(pageH3).containsText("100 spaces are waiting to be discovered");
    }

    @Test
    public void usersSeeNumberOfBookingsLastWeek() {
        page.navigate("localhost:8080");
        Locator pageParagraph = page.locator("p");
        assertThat(pageParagraph).containsText("123 bookings were made last week");
    }
    @Test
    public void usersSeeEmail() {
        page.navigate("localhost:8080/contactus");
        Locator pageBody = page.locator("body");
        assertThat(pageBody).containsText("info@makersbnb.com");
    }

    @Test
    public void usersSeeComingSoonMessage() {
        page.navigate("localhost:8080/termsandconditions");
        Locator pageBody = page.locator("body");
        assertThat(pageBody).containsText("Coming soon! In the meantime, please behave yourselves.");
    }

    @Test
    public void usersSeeJoinNowAndUserNumber() {
        page.navigate("localhost:8080/signup");
        Locator pageH1 = page.locator("h1");
        assertThat(pageH1).containsText("Join now to become user number 57");
    }
}