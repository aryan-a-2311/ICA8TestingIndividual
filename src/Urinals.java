import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Urinals {
    static String stringToCheck;
    static BufferedReader reader;
    static ArrayList<Integer> arrayofStr = new ArrayList<>();
    static boolean exitLoop = true;
    public static void keyboardInput()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter String: ");
        stringToCheck = sc.next();
        if(stringToCheck.equals("-1")) {
            exitLoop = false;
            System.exit(-1);
        }
    }

    public static int fileExists() {
        try {
            // Enter file path here
            reader = new BufferedReader(new FileReader("src/Inputs.dat"));
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }

    public static int fileReader() throws IOException {
        String tempStr;
        try
        {
            if((tempStr = reader.readLine()) == null)
                return -1;
        }
        catch (IOException e)
        {
            return -1;
        }

        while((tempStr)!=null){
            if(validateInputLength(tempStr) != -1 && validateInputType(tempStr) != -1)
            {
                arrayofStr.add(findAvailability(tempStr));
            }
            else{
                arrayofStr.add(-1);
            }
            tempStr = reader.readLine();
        }
        createWriteFile(arrayofStr);
        return 1;
    }

    public static int createWriteFile(ArrayList<Integer> availableStalls)
    {
        File writeFile = new File("rule.txt");
        int cnt = 1;
        
        while(writeFile.exists()) {
            writeFile = new File("rule" + cnt + ".txt");
            cnt++;
        }
        
        FileWriter outputWriter;
        try {
            outputWriter = new FileWriter(writeFile);
        } catch (IOException e) {
            return -1;
        }

        for (Integer availableStall : availableStalls) {
            try {
                outputWriter.write(availableStall + "\n");
            } catch (IOException e) {
                return -1;
            }
        }

        try {
            System.out.println("File Created");
            outputWriter.close();
        }
        catch (IOException e) {
            return -1;
        }

        return 1;
    }

    public static int validateInputLength(String bitString)
    {
        if(bitString.length() == 0 || bitString.length() > 20)
        {
            return -1;
        }
        return 1;
    }

    public static int validateInputType(String bitString)
    {
        for(int i=0; i < bitString.length(); i++)
        {
            if(bitString.charAt(i) != '0' && bitString.charAt(i) != '1')
            {
                return -1;
            }
        }
        return 1;
    }

    public static int findAvailability(String bitString) {
        if(bitString.length() == 1){
            if(bitString.charAt(0) == '0')
                return 1;
            else
                return 0;
        }

        for(int i=0; i < bitString.length() - 1; i++) {
            if (bitString.charAt(i) == '1' && bitString.charAt(i + 1) == '1')
                return -1;
        }

        StringBuilder strModifier = new StringBuilder(bitString);
        int answer = 0;

        for(int i=0; i < strModifier.length(); i++)
        {
            if (i == 0){
                if(strModifier.charAt(i) == '0')
                {
                    if(strModifier.charAt(i+1) == '0') {
                        strModifier.setCharAt(i, '1');
                        answer++;
                    }
                }
            }
            else if (i == strModifier.length()-1)
            {
                if (strModifier.charAt(i) == '0'){
                    if (strModifier.charAt(i-1) == '0') {
                        strModifier.setCharAt(i, '1');
                        answer++;
                    }
                }
            }
            else
            {
                if(strModifier.charAt(i) == '0')
                {
                    if(strModifier.charAt(i-1) == '0' && strModifier.charAt(i+1) == '0')
                    {
                        strModifier.setCharAt(i, '1');
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("================== MENU ==================");
        System.out.println("1. Input from Keyboard");
        System.out.println("2. Inputs from File");
        System.out.println("Select your Choice(1 or 2): ");
        int choice = sc.nextInt();

        if(choice == 1)
        {
            while(exitLoop){
                keyboardInput();
                if (validateInputLength(stringToCheck) != -1 && validateInputType(stringToCheck) != -1) {
                    System.out.println("Free Urinals: " + findAvailability(stringToCheck));
                } else {
                    System.out.println("Free Urinals: -1");
                }
            }
        }
        else if (choice == 2)
        {
            fileExists();
            fileReader();
        }
        else
        {
            System.out.println("Wrong Input");
        }
    }
}
