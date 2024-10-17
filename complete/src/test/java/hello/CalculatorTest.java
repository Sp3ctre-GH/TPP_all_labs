package hello;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    // Правильний тест
    @Test
    public void Righttest() {
        Expression e = new ExpressionBuilder("1+1").build();
        double result = e.evaluate();
        assertEquals(2.0, result, "1+1 should be result");
    }

    // Неправильний тест
//    @Test
//    public void Wrongtest() {
//        Expression e = new ExpressionBuilder("5-1").build();
//        double result = e.evaluate();
//        assertEquals(2.0, result, "5-1 should not be result (this test will fail)");
//    }
}