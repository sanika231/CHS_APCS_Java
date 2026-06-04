public class P5_Thatte_Sanika_RecursiveReverseAndPalindrome{
    public static String recursiveStringReverse(String str){
        if(str.length()==0){
            return "";
        }else{
            return str.charAt(str.length()-1)+recursiveStringReverse(str.substring(0,str.length()-1));
        }
    }
    
    public static boolean recursiveIsPalindrome(String str){
        if(str.length()==0 || str.length()==1){
            return true;
        }else{
            if(str.charAt(0)==str.charAt(str.length()-1)){
                return recursiveIsPalindrome(str.substring(1,str.length()-1));
            }
        }
        return false;
    }
}
