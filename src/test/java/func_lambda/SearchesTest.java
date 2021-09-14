package func_lambda;

import org.junit.jupiter.api.Test;

import javax.naming.directory.SearchResult;
import java.io.SequenceInputStream;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchesTest {

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
                (double) -10,
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
    void testFindFirstProperFractionByUserId(){
        assertEquals(
                new Fraction(0, 1),
                new Searches().findFirstProperFractionByUserId("1")
        );
    }

    @Test
    void testFindUserFamilyNameByImproperFraction(){
        assertEquals(
                List.of("Torres", "Torres"),
                new Searches().findUserFamilyNameByImproperFraction()
                        .collect(Collectors.toList())
        );
    }
}
