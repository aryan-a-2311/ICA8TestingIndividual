public class Urinals {
    public boolean validateInputLength(String bitString)
    {
        return bitString.length() <= 20;
    }

    public boolean validateInputType(String bitString)
    {
        for(int i=0; i < bitString.length(); i++)
        {
            if(bitString.charAt(i) != '0' && bitString.charAt(i) != '1')
            {
                return false;
            }
        }
        return true;
    }

    public int findAvailability(String bitString) {
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
        return 0;
    }
}
