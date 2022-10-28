import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.lang.reflect.Executable;

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
        String s4 = "10001";
        String s5 = "00000";
        String s6 = "01000";
        String s7 = "0000";
        urinals urinal = new urinals();
        assertEquals(1, urinal.countFreeUrinals(s1));
        assertEquals(1,urinal.countFreeUrinals(s2));
        assertEquals(0,urinal.countFreeUrinals(s3));
        assertEquals(1,urinal.countFreeUrinals(s4));
        assertEquals(3,urinal.countFreeUrinals(s5));
        assertEquals(1,urinal.countFreeUrinals(s6));
        assertEquals(2,urinal.countFreeUrinals(s7));
        System.out.println("====== Tirthkumar Atulkumar Patel == TEST 3 EXECUTED");
    }

    @Test
    void InputFileFound(){

        String s1 = "src/main/resources/InputFile";

        assertDoesNotThrow(() -> {
            urinals.Input2(s1);
        });

        System.out.println("====== Tirthkumar Atulkumar Patel === TEST 4 EXECUTED");

    }

    @Test
    void InputFIleNotFound()
    {
        String s2 = "src/main/resources/InputFile1";
        assertThrows(FileNotFoundException.class, () ->{
            urinals.Input2(s2);
        });

        System.out.println("====== Tirthkumar Atulkumar Patel === TEST 5 EXECUTED");

    }
}
