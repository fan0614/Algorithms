package string.stringfind;

import java.util.ArrayList;

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
    //所有以s为前缀的键
    public Iterable<String> keyWithPrefix(String s){
        return new ArrayList<>();
    }
    //所有和s匹配的键（其中"."能够匹配任意字符）
    public Iterable<String> keysThatMatch(String s){
        return new ArrayList<>();
    }
    //键值对的数量
    public int size(){
        return 0;
    }
    //符号表中的所有键
    public Iterable<String> keys(){
        return new ArrayList<>();
    }

}
