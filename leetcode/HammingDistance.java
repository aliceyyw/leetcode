package leetcode;

/**
 * Created by wyy on 2/7/17.
 */
public class HammingDistance {
    private int x,y;
    public HammingDistance(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int hammingDistance(){
        /*String a,b;
        int result=0;
        a = java.lang.Integer.toBinaryString(x);
        b = java.lang.Integer.toBinaryString(y);
        int lena=a.length();
        int lenb=b.length();
        int gap = Math.abs(lena-lenb);
       if(lena>lenb){
            for(int i=0;i<gap;i++){
                if(a.charAt(i)!='0')
                    result++;
            }
            for (int j=gap;j<lena;j++){
                if(a.charAt(j)!=b.charAt(j-gap))
                    result++;
            }

        }else if(lena<=lenb){
            for(int k=0;k<gap;k++){
                if(b.charAt(k)!='0')
                    result++;
            }
            for(int m=gap;m<lenb;m++){
                if(b.charAt(m)!=a.charAt(m-gap))
                    result++;
            }

        }


        System.out.println(a+"\n"+b);
        System.out.println("lena lenb gap :"+lena+" "+lenb+" "+gap);
        */
        int result=0;
        System.out.println(x+"\n"+y);
        result = x^y;

        return Integer.bitCount(result);


    }

}
