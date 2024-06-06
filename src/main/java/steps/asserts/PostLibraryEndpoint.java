package steps.asserts;

import org.junit.jupiter.api.Assertions;

public class PostLibraryEndpoint {

    public static <T> void shouldBeEquals(T actual, T expected) {
        Assertions.assertEquals(expected, actual);
    }
}
