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

        String s1 = "0";
        String s2 = "00";
        String s3 = "01";
        urinals urinal = new urinals();
        assertEquals(1, urinal.countFreeUrinals(s1));
        assertEquals(1,urinal.countFreeUrinals(s2));
        assertEquals(0,urinal.countFreeUrinals(s3));
        System.out.println("====== Tirthkumar Atulkumar Patel == TEST 3 EXECUTED");
    }
}
