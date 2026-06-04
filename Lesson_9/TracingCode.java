public class TracingCode{
    //public static void main(String[] args){
    public String removeString(String str, String a) {
        String output = "";
        int i = 0;
        while (i < str.length() - a.length()){
            if(!str.substring(i, i + a.length()).equalsIgnoreCase(a)){
                output = output + str.substring(i, i + 1);
            }
            else{
                i = i + a.length();
            }
            i++;
        }
        return output;
    //}
    }
}
