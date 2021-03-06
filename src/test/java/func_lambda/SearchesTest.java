package func_lambda;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {

    @Test
    void testFindUserFamilyNameByUserNameDistinct() {
        assertEquals(
                List.of("Torres"),
                new Searches().findUserFamilyNameByUserNameDistinct("Paula")
                        .collect(Collectors.toList())
        );
    }

    @Test
    void testFindFractionNumeratorByUserFamilyName() {
        assertEquals(
                List.of(0, 1, 2),
                new Searches().findFractionNumeratorByUserFamilyName("Fernandez")
                        .collect(Collectors.toList())
        );
    }

    @Test
    void testFindUserFamilyNameByFractionDenominator() {
        assertEquals(
                List.of("Blanco", "López"),
                new Searches().findUserFamilyNameByFractionDenominator(5)
                        .collect(Collectors.toList())
        );
    }

    @Test
    void testFindUserFamilyNameInitialByAnyProperFraction() {
        assertEquals(
                List.of("F", "B", "L", "B"),
                new Searches().findUserFamilyNameInitialByAnyProperFraction()
                        .collect(Collectors.toList())
        );
    }

    @Test
    void testFindUserIdByAnyProperFraction() {
        assertEquals(
                List.of("1", "2", "3", "5"),
                new Searches().findUserIdByAnyProperFraction()
                        .collect(Collectors.toList())
        );
    }

    @Test
    void testFindFractionMultiplicationByUserFamilyName() {
        assertEquals(
                new Fraction(0, -360),
                new Searches().findFractionMultiplicationByUserFamilyName("Blanco")
        );
    }

    @Test
    void testFindFirstFractionDivisionByUserId() {
        assertEquals(
                new Fraction(-6, 15),
                new Searches().findFirstFractionDivisionByUserId("3")
        );
    }

    @Test
    void testFirstDecimalFractionByUserName() {
        assertEquals(
                (double) 2,
                new Searches().findFirstDecimalFractionByUserName("Ana")
        );
    }

    @Test
    void testFindUserIdByAllProperFraction() {
        assertEquals(
                List.of(),
                new Searches().findUserIdByAllProperFraction()
                        .collect(Collectors.toList())
        );
    }

    @Test
    void testFindDecimalImproperFractionByUserName() {
        assertEquals(
                List.of(2.0, (double) 4 / 3), //1.33
                new Searches().findDecimalImproperFractionByUserName("Ana")
                        //.map(dbl -> (double)Math.round(dbl * 100d) / 100d)
                        .collect(Collectors.toList())
        );
    }

    @Test
    void testFindFirstProperFractionByUserId() {
        assertEquals(
                new Fraction(0, 1),
                new Searches().findFirstProperFractionByUserId("1")
        );
    }

    @Test
    void testFindUserFamilyNameByImproperFraction() {
        assertEquals(
                List.of("Torres", "Torres"),
                new Searches().findUserFamilyNameByImproperFraction()
                        .collect(Collectors.toList())
        );
    }

    @Test
    void testFindHighestFraction() {
        assertEquals(
                new Fraction(1, 0),
                new Searches().findHighestFraction()
        );
    }

    @Test
    void testFindUserNameByAnyImproperFraction() {
        assertEquals(
                List.of("Oscar", "Ana", "Oscar", "Paula", "Antonio", "Paula"),
                new Searches().findUserNameByAnyImproperFraction()
                        .collect(Collectors.toList())
        );
    }

    @Test
    void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {
        assertEquals(
                List.of("Blanco", "López"),
                new Searches().findUserFamilyNameByAllNegativeSignFractionDistinct()
                        .collect(Collectors.toList())
        );
    }

    @Test
    void testFindDecimalFractionByUserName() {
        assertEquals(
                List.of(2.0d, -0.2d, 0.5d, (double) 4 / 3),
                new Searches().findDecimalFractionByUserName("Ana")
                        .collect(Collectors.toList())
        );
    }

    @Test
    void testFindDecimalFractionByNegativeSignFraction() {
        assertEquals(
                List.of(-0.2, -0.5, -0.0),
                new Searches().findDecimalFractionByNegativeSignFraction()
                        .collect(Collectors.toList())
                );
    }

    @Test
    void testFindFractionAdditionByUserId(){
        assertEquals(
                new Fraction(3,1),
                new Searches().findFractionAdditionByUserId("1")
        );
    }

    @Test
    void testFindFirstFractionSubtractionByUserName() {
        assertEquals(
                new Fraction(1, 1),
                new Searches().findFirstFractionSubtractionByUserName("1")
        );
    }
}
