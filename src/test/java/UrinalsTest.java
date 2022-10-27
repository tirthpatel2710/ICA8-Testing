import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UrinalsTest
{
    @Test
    public void CheckEmpty()
    {
        String s1="101010";
        urinals urinal = new urinals();
        assertEquals(false , urinal.checkEmpty(s1));
        System.out.println("====== Tirthkumar Atulkumar Patel == TEST 1 EXECUTED");
    }
    @Test
    public void isGoodString()
    {
        String s = "1010102";
        urinals urinal = new urinals();
        assertEquals(false, urinal.isGoodString(s));
        System.out.println("====== Tirthkumar Atulkumar Patel == TEST 2 EXECUTED");
    }

    @Test
    void countFreeUrinals() {

        String s = "0";
        urinals urinal = new urinals();
        assertEquals(1, urinal.countFreeUrinals(s));
        System.out.println("====== Tirthkumar Atulkumar Patel == TEST 3 EXECUTED");
    }
}
