import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    private Polynomial polynomial;

    @BeforeEach
    public void Setup(){
        int[] pCoefficients = {32, 3, 5, 22, 33, 42};
        polynomial = new Polynomial(pCoefficients);
    }

    @Test
    public void  testGetCoefficientOutOfRange(){
        NoSuchElementException thrown = assertThrows(
                NoSuchElementException.class,
                () -> polynomial.getCoefficient(-5),
                "Expected .getCoefficient() to throw, but it didn't");
        NoSuchElementException thrown2 = assertThrows(
                NoSuchElementException.class,
                () -> polynomial.getCoefficient(20),
                "Expected .getCoefficient() to throw, but it didn't");
        assertEquals(42,polynomial.getCoefficient(5));
    }


}