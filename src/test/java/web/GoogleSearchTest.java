package web;

import org.assertj.core.api.Assertions;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;
import web.basic.BaseTest;

public class GoogleSearchTest extends BaseTest {

    private static final String PAGE_URL = "https://www.google.co.il/";
    private static final String SEARCH_INPUT = "Java";
    private static final String SEARCH_NEGATIVE_INPUT = "Interview";
    private static int SEARCH_RESULTS_COUNT;
    private GoogleDefaultPage googleDefaultPage = new GoogleDefaultPage();
    private GoogleSearchResultPage googleSearchResultPage;

    @Description("Search 'Java' in Google search and verify results")
    @Test
    public void searchTest() {
        getGooglePage();
        searchInput();
        printSearchResult();
        verifyFirstResult();
        verifyLastResult();
    }

    @Description("Navigate to https://www.google.co.il/ Page")
    public void getGooglePage() {
        getPage(PAGE_URL);
        Assertions.assertThat(googleDefaultPage.isExist())
                .withFailMessage("Not Expected - It's not Default Google Page ")
                .isTrue();
    }

    @Description("Type “Java” into search field And Press on “Google Search” button")
    private void searchInput() {
        googleDefaultPage.setSearchInput(SEARCH_INPUT);
        googleSearchResultPage = googleDefaultPage.clickOnSearchButton();
    }

    @Description("Print only search result links")
    private void printSearchResult() {
        SEARCH_RESULTS_COUNT = googleSearchResultPage.getSearchResultsCount();
        googleSearchResultPage.printSearchResults();
    }

    @Description("Verify first search result contains the word “Java”")
    private void verifyFirstResult() {
        Assertions.assertThat(googleSearchResultPage.validateResultExist(SEARCH_INPUT, 1))
                .withFailMessage("Not Expected - Word %s is not in the %s result ", SEARCH_INPUT, 1)
                .isTrue();
    }

    @Description("Verify last search result does not contain the word “Interview”")
    private void verifyLastResult() {
        Assertions.assertThat(googleSearchResultPage.validateResultExist(SEARCH_NEGATIVE_INPUT,
                SEARCH_RESULTS_COUNT))
                .withFailMessage("Not Expected - Word %s is in the %s result ", SEARCH_NEGATIVE_INPUT,
                        SEARCH_RESULTS_COUNT)
                .isFalse();
    }

}
