package func_lambda;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchesTest {

    @Test
    void testFindUserFamilyNameByUserNameDistinct(){
        assertEquals(
                List.of("Torres"),
                new Searches().findUserFamilyNameByUserNameDistinct("Paula")
                        .collect(Collectors.toList())
        );
    }
}
