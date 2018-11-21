package string.stringfind;

//以字符串位键的符号表的API
public class StringST<Value> {
    //创建一个符号表
    public StringST(){}
    //向表中插入键值对(如果值为null则删除键key)
    public void put(String key,Value val){}
    //键key所对应的值(如果键不存在则返回null)
    public void get(String key){}
    //删除键key（和它的值）
    public void delete(String key){}
    //表中是否保存着key的值
    public boolean contains(String key){return false;}
    //符号表是否为空
    public boolean isEmpty(){return false;}
    //s的前缀中最长的值
    public String longestPrefisOf(String s){
        return "";
    }

}
