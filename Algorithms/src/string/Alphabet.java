package string;

//字母表的API
public class Alphabet {
    private char[] res;
    private String s;
    //根据s中的字符创建一张新的字母表
    public Alphabet(String s){
        res = s.toCharArray();
        this.s = s;
    }
    //获取字母表中索引位置的字符
    public char toChar(int index){
        return s.charAt(index);
    }
    //获取c的索引，在0到R-1之间
    public int toIndex(char c){
        return s.indexOf(c);
    }
    //c在字母表之吗
    public boolean contains(char c){
        for(char ch : res){
            if(ch == c) return true;
        }
        return false;
    }
    //基数，字符表中的字符数量
    public int R(){
        return res.length;
    }
    //表示一个索引所需要的位数
    public int lgR(){
        return (int)(Math.log(R())/Math.log(10)+1);
    }
    //将s转化为R进制的整数
    public int[] toIndices(String s){
        return new int[0];
    }
    //将R进制的整数转换为基于该字母表的字符串
    public String toChars(int[] indices){
        return "";
    }
}
