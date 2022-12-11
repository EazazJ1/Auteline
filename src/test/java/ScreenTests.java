import org.junit.*;
import MainApp.Screen;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class ScreenTests {
@Rule
public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Test
    public void T001_displayMessage_PrintGivenParameterWithoutEnterLine() {
        Screen screen = new Screen();
        screen.displayMessage("Hello World");
        screen.displayMessage("Hello World");

        Assert.assertEquals("Hello WorldHello World",systemOutRule.getLog().trim());//outputStreamCaptor.toString().trim());
    }
    @Test
    public void T002_displayMessageLine_PrintGivenParameterWithEnterLine() {
        Screen screen = new Screen();
        screen.displayMessageLine("Hello World");

        Assert.assertEquals("Hello World", systemOutRule.getLog().trim());
    }
    @Test
    public void T003_displayDollarAmount_PrintParameterWithDollarSign() {
        Screen screen = new Screen();
        screen.displayDollarAmount(1000);

        Assert.assertEquals("$1,000.00", systemOutRule.getLog().trim());
    }

    @Test
    public void T004_getMessage_ReturnParameter() {
        Screen screen = new Screen();
        String actual = screen.getMessage("Test Message");

        Assert.assertEquals("Test Message",actual);
    }
    @Test
    public void T005_getDollarAmount_ReturnParameterWithDollarSign() {
        Screen screen = new Screen();
        String actual = screen.getDollarAmount(1000);

        Assert.assertEquals("$1,000.00",actual);
    }
}
