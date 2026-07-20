

public class palindrome {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String a= String.valueOf(x);
        int l =0;
        int r =a.length()-1;
        while(l<r){
            if(a.charAt(l)!=a.charAt(r)){
               return false;
            }

            l++;
            r--;
        }
        
        return true;
    }
} 
    

