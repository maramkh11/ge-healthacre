package web;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.apache.commons.lang3.StringUtils;
import utils.Report;

import static com.codeborne.selenide.Selenide.$$x;

public class GoogleSearchResultPage extends GoogleDefaultPage {

    private final ElementsCollection searchLinks =
            $$x("//div[@class='v7W49e']//div[@class='MjjYud']//a//cite/../..");

    public int getSearchResultsCount() {
        Report.info("Get search results count");
        return searchLinks.should(CollectionCondition.sizeGreaterThan(0)).size();
    }

    public boolean validateResultExist(String value, int index) {
        Report.info("Validate value %s in results list [%s]", value, index);
        return getSearchResultsCount() > (index - 1) &&
                StringUtils.containsIgnoreCase(searchLinks.get(index - 1).getText(), value);
    }

    public void printSearchResults() {
        Report.info("Print search results");
        searchLinks.forEach(link -> Report.info("Link: " + link.getAttribute("href")));
    }

}
