package Test;

import org.junit.jupiter.api.*;
import ru.gb.HomeWorks_core3.lesson6.Calculator;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void init(){
        calculator = new Calculator();
        calculator.setA(2);
        calculator.setB(3);
    }

    @Test
    public void testCalcSum(){
        Assertions.assertEquals(7, calculator.sum(3, 4));
    }

    @Test
    public void testCalcWrongSum(){
        Assertions.assertNotEquals(7, calculator.sum(4, 4));
    }

    @Test
    public void testCalcSumWithNull(){
        Assertions.assertEquals(7, calculator.sum(7, 0));
    }

    @Test
    public void testCalcInnerSum(){
        Assertions.assertEquals(5, calculator.sum());
    }

    @AfterAll
    public static void end(){
        System.out.println("END");
    }
}
