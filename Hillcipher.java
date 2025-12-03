public class Hill {
    static int[][] K={{9,4},{5,7}}, INV={{7,22},{21,9}};
    
    static String enc(String s){
        s=s.toUpperCase().replaceAll("[^A-Z]","");
        if(s.length()%2!=0) s+="X";
        String r="";
        for(int i=0;i<s.length();i+=2){
            int a=s.charAt(i)-'A', b=s.charAt(i+1)-'A';
            r+=(char)((K[0][0]*a+K[0][1]*b)%26+'A');
            r+=(char)((K[1][0]*a+K[1][1]*b)%26+'A');
        }
        return r;
    }
    
    static String dec(String s){
        String r="";
        for(int i=0;i<s.length();i+=2){
            int a=s.charAt(i)-'A', b=s.charAt(i+1)-'A';
            r+=(char)((INV[0][0]*a+INV[0][1]*b)%26+'A');
            r+=(char)((INV[1][0]*a+INV[1][1]*b)%26+'A');
        }
        return r;
    }

    public static void main(String[] a){
        String m="HELLO";
        String e=enc(m);
        System.out.println(e);
        System.out.println(dec(e));
    }
}
