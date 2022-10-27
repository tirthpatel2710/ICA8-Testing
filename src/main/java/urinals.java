//import java.util.Scanner;

public class urinals {

    /**
     * @author Tirthkumar Atulkumar Patel
     */
    public boolean checkEmpty(String s)
    {
        return s.length() == 0;
    }

    public boolean isGoodString(String s)
    {

        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)!='1' && s.charAt(i)!='0')
                return false;
        }

        for(int i=0; i<s.length()-1; i++)
        {
            if (s.charAt(i)=='1' && s.charAt(i + 1)=='1')
                return false;
        }

        return true;
    }

    public int countFreeUrinals(String s)
    {
        int count = 0;

        if(s.length()==1)
        {
            if(s.charAt(0)=='0')
                count++;
        }

        return count;
    }

    public static void main(String[] args)
    {
        System.out.println("How you want to give input : ");
        System.out.println("Click 1 to enter a string manually");
        System.out.println("Click 2 to take file as input");
    }
}
