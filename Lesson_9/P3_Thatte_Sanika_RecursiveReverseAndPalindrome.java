/*
    Name:       Sanika Thatte
    Date:       11/22/25
    Period:     3

    Is this lab fully working?  Yes
*/

public class P3_Thatte_Sanika_RecursiveReverseAndPalindrome{
    public static String recursiveStringReverse(String str){
        if(str.length()==0){
            return "";
        }else{
            return str.charAt(str.length()-1)+recursiveStringReverse(str.substring(0,str.length()-1));
        }
    }
    
    public static boolean recursiveIsPalindrome(String str){
        str = removePunctuation(str);
        //System.out.println(str);
        if(str.length()==0 || str.length()==1){
            return true;
        }else{
            if(str.charAt(0)==str.charAt(str.length()-1)){
                return recursiveIsPalindrome(str.substring(1,str.length()-1));
            }
        }
        return false;
    }
    
    public static void main(String[] args){
        System.out.println(recursiveIsPalindrome("radar"));
        System.out.println(recursiveIsPalindrome("J"));
        System.out.println(recursiveIsPalindrome("Lewd did I live, & evil I did dwel."));
        System.out.println(recursiveIsPalindrome("I like Java"));
        System.out.println(recursiveIsPalindrome("Straw? No, too stupid a fad, I put soot on warts."));
        System.out.println(recursiveIsPalindrome("***Nurse!*** I spy gypsies....run!!!!!"));
        System.out.println(recursiveIsPalindrome(""));
    }
    
    public static String removePunctuation(String str){
        String s = "";
        str = str.toLowerCase();
        for(int i=0;i<str.length();i++){
            if(Character.isLetter(str.charAt(i))){
                s = s+str.charAt(i);
            }
        }
        return s;
    }
}
