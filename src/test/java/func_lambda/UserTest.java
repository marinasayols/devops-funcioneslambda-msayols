package func_lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    private User user;

    @BeforeEach
    void before() {

        List<Fraction> fractions1 = List.of(
                new Fraction(0, 1),
                new Fraction(1, -1),
                new Fraction(2, 1)
        );
        user = new User("1", "Oscar", "Fernandez", fractions1);
    }

    @Test
    void testGetId(){
        assertEquals("1", user.getId());
    }

    @Test
    void testGetName(){
        assertEquals("Oscar", user.getName());
    }

    @Test
    void testSetName(){
        user.setName("Laura");
        assertEquals("Laura", user.getName() );
    }

    @Test
    void testGetFamilyName(){
        assertEquals("Fernandez", user.getFamilyName());
    }

    @Test
    void testSetFamilyName(){
        user.setFamilyName("Garcia");
        assertEquals("Garcia", user.getFamilyName());
    }

    @Test
    void testGetFactions(){
        assertEquals(
                List.of(
                        new Fraction(0,1),
                        new Fraction(1, -1),
                        new Fraction(2, 1)),
                user.getFractions());
    }

}
