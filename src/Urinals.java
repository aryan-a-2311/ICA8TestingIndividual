public class Urinals {
    public boolean validateInputLength(String bitString)
    {
        if(bitString.length() <= 20)
            return true;
        else
            return false;
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
}
