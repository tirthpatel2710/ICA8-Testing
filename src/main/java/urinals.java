import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class urinals {

    /**
     * @author Tirthkumar Atulkumar Patel
     */
    static Scanner scanner = new Scanner(System.in);
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
    public static String Input1()
    {
        System.out.println("Enter the String to check for number of free Urinals: ");
        String input = scanner.nextLine();
        return input;
    }

    public static void Input2(String s) throws FileNotFoundException {

            FileReader myObj = new FileReader(s);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if(data.equals("EOF") || data.equals("-1"))
                    break;

                System.out.println(data);

            }
            myReader.close();
    }

    public static void main(String[] args)
    {
        System.out.println("How you want to give input : ");
        System.out.println("Click 1 to enter a string manually");
        System.out.println("Click 2 to take file as input");
        String inputType = scanner.nextLine();

        if(inputType.equals("1"))
        {
            String s = Input1();
            System.out.println(s);
        }
        else
        {
            String s = "src/main/resources/InputFile";
            try {
                Input2(s);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }




}
