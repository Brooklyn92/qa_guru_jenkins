package junitstudy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertStudy {

    @Test
    public void baseAssertions() {
        //assertEquals(2,1+1); //expected -ожидаемый результат; actual - фактический результат
        // assertNull(null); // утверждение того, что значение пустое
        //assertNotNull("Hello");//утверждение того, что значение не пустое
        //assertSame("Jinx","Jinx"); // проверяет то, что ожидаемый результат является тем же самым, что и фактический результат
        assertArrayEquals(new int[] {1,2,3},new int[]{1,2,3});
    }
    @Test
    void p1() {
        Assertions.assertAll(
                "Проверка",
                () ->  assertEquals(2,1+1),
                () ->  assertEquals(3,1+1),
                () ->  assertEquals(2,1+1),
                () ->  assertEquals(2,1+1)
        );
    }

}
