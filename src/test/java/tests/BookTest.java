package tests;

import api.BookApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BooksPage;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class BookTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(BookTest.class);
    private static final BookApi apiService = new BookApi();
    private static final BooksPage booksPage = new BooksPage();

    @Test
    public void compareBookTitles()throws IOException, InterruptedException{
        logger.info("Getting book titles from API");
        List<String> apiTitles = apiService.getBooksTitiles();
        logger.info("API returned {} titles", apiTitles.size());

        logger.info("Getting book titles from UI page");
        List<String> pageTitles = booksPage.getBookTitlesFromPage();
        logger.info("UI page returned {} titles", pageTitles.size());

        logger.info("Verify that book titles are matched");
        if (!new HashSet<>(apiTitles).equals(new HashSet<>(pageTitles))) {
            logger.warn("Mismatch detected between API and UI titles");
            logger.debug("API titles: {}", apiTitles);
            logger.debug("UI titles: {}", pageTitles);
        }

        Assert.assertEquals(new HashSet<>(apiTitles), new HashSet<>(pageTitles),
                "Lists of books don't match");
    }
}
