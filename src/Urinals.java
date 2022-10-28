import java.util.Scanner;

public class Urinals {
    static String stringToCheck;

    public static void keyboardInput()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        stringToCheck = sc.next();
    }

    public static int validateInputLength(String bitString)
    {
        if(bitString.length() > 20)
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

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("================== MENU ==================");
        System.out.println("1. Input from Keyboard");
        System.out.println("2. Inputs from File");
        System.out.println("Select your Choice(1 or 2): ");
        int choice = sc.nextInt();

        if(choice == 1)
        {
            keyboardInput();
            if(validateInputLength(stringToCheck) != -1 && validateInputType(stringToCheck) != -1)
            {
                System.out.println("Free Urinals: " + findAvailability(stringToCheck));
            }
            else{
                System.out.println("Free Urinals: -1");
            }
        }
    }
}
