package web;

import com.codeborne.selenide.SelenideElement;
import utils.Report;

import static com.codeborne.selenide.Selenide.$x;

public class GoogleDefaultPage extends BasePage {

    private final SelenideElement searchGoogleButton =
            $x("(//form[@role='search']//input[@role='button'])[1]");
    protected final SelenideElement searchInput = $x("//input[@role='combobox']");

    @Override
    public boolean isExist() {
        return searchInput.isDisplayed();
    }

    public void setSearchInput(String value) {
        Report.info("Set %s in search input", value);
        searchInput.setValue(value);
    }

    public GoogleSearchResultPage clickOnSearchButton() {
        Report.info("Click on Search Google button");
        searchGoogleButton.click();
        return new GoogleSearchResultPage();
    }

}
