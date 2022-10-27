import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UrinalsTest
{
    @Test
    public void CheckEmpty()
    {
        String s1="";
        urinals urinal = new urinals();
        assertTrue(urinal.checkEmpty(s1));
    }
}
