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

            return count;
        }
        else if(s.length()==2)
        {
            if(s.charAt(0)=='0' && s.charAt(1)=='0')
                return 1;
            else
                return 0;
        }

        char[] input = s.toCharArray();

        for(int i=0; i<input.length; i++)
        {
            if(i==0)
            {
                if(input[i]=='0' && input[i+1]=='0')
                {
                    input[i] = '1';
                    count++;
                }
            }
            else if(i==input.length-1)
            {
                if(input[i-1]=='0' && input[i]=='0')
                {
                    input[i]='1';
                    count++;
                }
            }
            else
            {
                if(input[i-1]=='0' && input[i+1]=='0' && input[i]=='0')
                {
                    input[i]='1';
                    count++;
                }
            }
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
