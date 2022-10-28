import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class urinals {

    /**
     * @author Tirthkumar Atulkumar Patel
     */
    static Scanner scanner = new Scanner(System.in);
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static List<String> l = new ArrayList<>();
    public static List<Integer> counter = new ArrayList<>();
    public static Integer filecounter = 0;
    //public static Map<>
    public boolean checkEmpty(String s)
    {
        return s.length() == 0;
    }

    public static boolean isGoodString(String s)
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

    public static int countFreeUrinals(String s)
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

    public static void Input2(String s) throws IOException {

            FileReader myObj = new FileReader(s);
            BufferedReader br = new BufferedReader(myObj);
            Scanner myReader = new Scanner(myObj);
            String str;

            while ((str = br.readLine())!= null) {

                if(isGoodString(str))
                l.add(str);
                else
                    l.add("-1");
            }
            myReader.close();
    }

    public int checkEmptyFile(String s)
    {
        File myObj = new File(s);

        if(myObj.length()==0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public static boolean OutputFileCreation(String s) throws IOException {
        File file = new File(s);
        boolean value = file.createNewFile();
        return value;
    }

    public static boolean WriteOutputFile(String s) throws IOException {
        FileWriter writer = new FileWriter(s);

        for(int i=0; i<counter.size(); i++)
        {
            writer.write(String.valueOf(counter.get(i)) + "\n");
        }

        if(writer.equals(writer))
        writer.flush();

        return true;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("How you want to give input : ");
        System.out.println("Click 1 to enter a string manually");
        System.out.println("Click 2 to take file as input");
        String inputType = scanner.nextLine();

        if(inputType.equals("1"))
        {
            String s = Input1();
            System.out.println(s);
            System.out.println(countFreeUrinals(s));
        }
        else
        {
            String s = "src/main/resources/InputFile";
            try {
                Input2(s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            int numberOffree;

            for (int i = 0; i < l.size(); i++)
            {
                if(l.get(i).equals("-1"))
                    counter.add(-1);
                else
                {
                    numberOffree = countFreeUrinals(l.get(i));
                    counter.add(numberOffree);
                }
            }

            String outputaddress = "src/rule_output/";
            boolean k = true;
            while(k == true){
                k = !OutputFileCreation(outputaddress + "rule" + filecounter + ".txt");
                if (!k){
                    break;
                }
                filecounter++;
            }

            boolean write = WriteOutputFile(outputaddress + "rule" + filecounter + ".txt");
            System.out.println("Output File has been created and Output has been written");
        }

    }


}
