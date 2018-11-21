import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
//    public enum Color{red,black,green}

static int a =10;
//    int b =5;
    public Test(int a){
        this.a = a;
    }
////
    public static void main(String [] args){
            String s = "";
            System.out.println(Math.pow(2,3));

//        Pattern p = Pattern.compile("a*b");
//        Matcher m = p.matcher("aaaaab");
//        boolean b = m.matches();
//        System.out.println(b);
//        String str="Java   string split Test";
//        String[] strarray=str.split("");
//        for (int i = 0; i < strarray.length; i++)
//            System.out.print(strarray[i]+":");

        //Test();
//        new Test(10);
//        char c = 65;
//        Random ran = new Random(1);
//        Random q = new Random(System.currentTimeMillis());
//        int a = ran.nextInt();
//        int b = q.nextInt();
//        System.out.println(a);
//        System.out.println(b);

//        byte a = 1;
//        byte b = 2,d = 3;
//        System.gc();
//        long start = Runtime.getRuntime().freeMemory();
//        byte c;
//        c=(byte)(a+b);
//        System.gc();
//        long end =  Runtime.getRuntime().freeMemory();
//        System.out.println(c);

        String str = "yin yu shi wo zui cai de yu yan";
        System.out.println(str);
        String reg = "\\b[a-z]{3}\\b";//匹配只有三个字母的单词

        //将规则封装成对象。
        Pattern p = Pattern.compile(reg);

        //让正则对象和要作用的字符串相关联。获取匹配器对象。
        Matcher m  = p.matcher(str);

        System.out.println(m.matches());//其实String类中的matches方法。用的就是Pattern和Matcher对象来完成的。
        //只不过被String的方法封装后，用起来较为简单。但是功能却单一。

        boolean b = m.find();//将规则作用到字符串上，并进行符合规则的子串查找。
        System.out.println(b);
        System.out.println(m.group());//用于获取匹配后结果。


        while(m.find())
        {
            System.out.println(m.group());
            System.out.println(m.start()+"...."+m.end());
            // start()  字符的开始下标（包含）
            //end()  字符的结束下标（不包含）
        }
//        String str = "wer1389980000ty1234564uiod234345675f";//将字符串中的数字替换成#。
//
//        str = str.replaceAll("\\d{5,}","#");
//
//        System.out.println(str);
//        String str1 = "erkktyqqquizzzzzo";//将叠词替换成$.  //将重叠的字符替换成单个字母。zzzz->z
//
//        str1 = str1.replaceAll("(.)\\1+","$1");
//
//        System.out.println(str1);
//        String str = "erkktyqqquizzzzzo";
//        String reg ="(.)\\1+";//按照叠词来进行切割
//        //可以将规则封装成一个组。用()完成。组的出现都有编号。
//        //从1开始。 想要使用已有的组可以通过  \n(n就是组的编号)的形式来获取。
//        String[] arr = str.split(reg);
//        System.out.println(arr.length);
//        for(String s : arr)
//        {
//            System.out.println(s);
//        }
//        String tel = "18900001111";
//        String telReg = "1[358]\\d{9}";
//        String str = "avg   bb   geig   glsd   abc";
//        String reg = "\\s+";//按照多个空格来进行切割
//        String[] arr = str.split(reg);
//        System.out.println(arr.length);
//        for(String s : arr)
//        {
//            System.out.println(s);
//        }
//        System.out.println(tel.matches(telReg));
        //System.out.println(Son.a);
       // System.out.println(Color[0]);
//        int n = 3;
//        System.out.println(n/2);
    }
//public static void sort(int[] a,int lo,int hi) {
//    if(hi<=lo) return;
//    //切分
//    int j = partition(a,lo,hi);
//    sort(a,lo,j-1);
//    sort(a,j+1,hi);
//
//}
//    public static int partition(int[] a,int lo,int hi) {
//        //左右扫描数组
//        int j = lo;
//        int i = hi+1;;
//        int v = a[lo];
//        while(true) {
//            while(v>=a[++j]){
//                if(j==hi) break;
//                //j++;
//            }
//            while(v<=a[--i]) {
//                if(i==lo) break;
//                //i--;
//            }
//            if(j>=i) {
//                break;
//            }
//            int t = a[i];
//            a[i] = a[j];
//            a[j] = t;
//        }
//        if(v>a[j]){
//        a[lo] = a[j];
//        a[j] = v;
//        return j;}
//        else {
//            a[lo] = a[j-1];
//            a[j-1] = v;
//            return j-1;
//        }
//    }
//    public static void main(String[] args) {
//        int[] a = {49,78,23,34,67,45,73,90,120,12,20,9,5};
//        int lo = 0;
//        int hi = a.length-1;
//        sort(a,lo,hi);
//        for(int i=0;i<a.length;i++) {
//            System.out.print(a[i]+" ");
//        }
//
//    }
}
