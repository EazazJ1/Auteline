import static org.junit.Assert.*;

import org.junit.*;

import main.java.DepositSlot;

public class DepositSlotTests {

    @Test
    public void T001_DepositSlot_Invoke_True() {
        DepositSlot testDepositSlot = new DepositSlot();
        boolean result = testDepositSlot.isEnvelopeReceived();

        assertTrue(result);
    }
}
