package library_service;

import entity.Author;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.get.GettingAuthorsBooksRq;
import models.get.GettingAuthorsBooksRs;
import models.get.GettingAuthorsBooksXmlRq;
import models.get.GettingAuthorsBooksXmlRs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.requestSteps.RequestSender;
import utils.DataHelper;

import java.util.ArrayList;
import java.util.List;

import static steps.asserts.GetLibraryEndpoint.shouldBeEquals;
import static utils.DataHelper.*;

@Epic("Get")
@Story("Получение информации")
public class GetLibraryTest {

    @Test
    @DisplayName("Получение списка книг в формате Json. Позитивный кейс")
    @Description("Получены ранее сохраненные книги")
    public void getBooksJsonSuccess() {
        Author author = getRegisteredAuthor();
        String bookTitle = getBookTitle();
        long bookId = DataHelper.getIdRegisteredBook(author, bookTitle);

        GettingAuthorsBooksRs expectedModel = new GettingAuthorsBooksRs();
        expectedModel.setBook(new GettingAuthorsBooksRs.Book(bookId, bookTitle, author));

        GettingAuthorsBooksRs actualModel = RequestSender
                .getBooksJsonResponse(new GettingAuthorsBooksRq(Long.toString(author.getId())))
                        .jsonPath().getList(".", GettingAuthorsBooksRs.class).get(0);

        shouldBeEquals(actualModel, expectedModel);

    }

    @Test
    @DisplayName("Получение списка книг в формате Xml. Позитивный кейс")
    @Description("Получены ранее сохраненные книги")
    public void getBooksXmlSuccess() {
        Author author = getRegisteredAuthor();
        String bookTitle = getBookTitle();
        long bookId = getIdRegisteredBook(author, bookTitle);

        List<GettingAuthorsBooksXmlRs.Book> expectedList = new ArrayList<>();
        expectedList.add(new GettingAuthorsBooksXmlRs.Book(bookId, bookTitle, author));
        GettingAuthorsBooksXmlRs expectedModel = new GettingAuthorsBooksXmlRs();
        expectedModel.setBooks(expectedList);

        GettingAuthorsBooksXmlRs actualModel = RequestSender
                .getBooksXmlResponse(new GettingAuthorsBooksXmlRq(author))
                .as(GettingAuthorsBooksXmlRs.class);

        shouldBeEquals(actualModel, expectedModel);

    }

}
