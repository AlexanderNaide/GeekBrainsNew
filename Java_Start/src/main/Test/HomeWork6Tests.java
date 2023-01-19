package Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gb.HomeWorks_core3.lesson6.HomeWork6;

public class HomeWork6Tests {

    HomeWork6 homeWork6;

    @BeforeEach
    void init(){
        homeWork6 = new HomeWork6();
    }

    //--------- Первый метод ----------

    @Test
    public void arrayAfterFourTest1(){
        Integer[] request = new Integer[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        Integer[] answer = new Integer[]{1, 7};
        Assertions.assertArrayEquals(answer, homeWork6.arrayAfterFour(request));
    }

    @Test
    public void arrayAfterFourTest2(){
        Integer[] request = new Integer[]{1, 2, 4, 4, 2, 3, 2, 1, 7};
        Integer[] answer = new Integer[]{2, 3, 2, 1, 7};
        Assertions.assertArrayEquals(answer, homeWork6.arrayAfterFour(request));
    }

    @Test
    public void arrayAfterFourTest3() {
        Integer[] request = new Integer[]{1, 1, 2, 3, 2, 1, 7};
        Assertions.assertThrowsExactly(RuntimeException.class, () -> homeWork6.arrayAfterFour(request));
    }

    //--------- Второй метод ----------

    @Test
    public void containsOneAndFour1(){
        Integer[] request = new Integer[]{1, 1, 4, 4, 1, 4, 4, 1, 4};
        Assertions.assertTrue(homeWork6.containsOneAndFour(request));
    }

    @Test
    public void containsOneAndFour2(){
        Integer[] request = new Integer[]{4, 4, 4, 4};
        Assertions.assertFalse(homeWork6.containsOneAndFour(request));
    }

    @Test
    public void containsOneAndFour3() {
        Integer[] request = new Integer[]{1, 1, 1};
        Assertions.assertFalse(homeWork6.containsOneAndFour(request));
    }

    @Test
    public void containsOneAndFour4() {
        Integer[] request = new Integer[]{1, 1, 2, 3, 2, 1, 7};
        Assertions.assertThrowsExactly(RuntimeException.class, () -> homeWork6.containsOneAndFour(request));
    }
}
