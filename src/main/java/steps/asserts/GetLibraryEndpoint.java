package steps.asserts;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetLibraryEndpoint {

    public static <T> void shouldBeEquals(T actual, T expected) {
        assertEquals(expected, actual);
    }
}
