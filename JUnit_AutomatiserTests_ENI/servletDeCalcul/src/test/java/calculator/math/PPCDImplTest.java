package calculator.math;

import static org.junit.Assert.*;
import org.junit.Test;

import calculator.math.PPCMImpl;

public class PPCDImplTest {
@Test
public void testPGCD() {
    PPCMImpl op = new PPCMImpl();
    assertEquals(new Long(30), op.calculer(new Long(15),new Long(10)));
    assertEquals(new Long(120), op.calculer(new Long(30),new Long(24)));
}
}
