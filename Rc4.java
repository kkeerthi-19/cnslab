public class RC4short {
    static byte[] rc4(byte[] key, byte[] data){
        int[] S=new int[256];
        for(int i=0;i<256;i++) S[i]=i;
        int j=0;
        for(int i=0;i<256;i++){
            j=(j+S[i]+key[i%key.length])&255;
            int t=S[i]; S[i]=S[j]; S[j]=t;
        }
        byte[] out=new byte[data.length];
        int i=0; j=0;
        for(int k=0;k<data.length;k++){
            i=(i+1)&255; j=(j+S[i])&255;
            int t=S[i]; S[i]=S[j]; S[j]=t;
            out[k]=(byte)(data[k]^S[(S[i]+S[j])&255]);
        }
        return out;
    }

    public static void main(String[] a){
        String msg="HELLO RC4", key="KEY";
        byte[] enc=rc4(key.getBytes(),msg.getBytes());
        byte[] dec=rc4(key.getBytes(),enc);
        System.out.println(new String(enc)); // encrypted (raw)
        System.out.println(new String(dec)); // decrypted
    }
}
