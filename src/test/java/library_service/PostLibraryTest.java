package library_service;

import entity.Author;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.post.SavingNewBookRq;
import models.post.SavingNewBookRs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.requestSteps.RequestSender;

import static steps.asserts.PostLibraryEndpoint.shouldBeEquals;
import static utils.DataHelper.*;

@Epic("Post")
@Story("Сохранение информации")
public class PostLibraryTest {

    @Test
    @DisplayName("Сохранение новой книги. Позитивный кейс")
    @Description("Получен успешный ответ")
    public void postBookSuccess() {
        Author author = getRegisteredAuthor();
        String bookTitle = getBookTitle();

        SavingNewBookRs expectedModel = new SavingNewBookRs();
        expectedModel.setBookId(getIdRegisteredBook(author, bookTitle) + 1);

        SavingNewBookRs actualModel = RequestSender
                .postBookResponse(new SavingNewBookRq(bookTitle, author))
                .as(SavingNewBookRs.class);

        shouldBeEquals(actualModel, expectedModel);
    }
}
