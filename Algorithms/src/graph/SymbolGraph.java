package graph;

import java.util.HashMap;
import java.util.Map;

public class SymbolGraph {
    private Map<String,Integer> st;   //符号名 -> 索引
    private String[] keys;      // 索引  -> 符号名
    private Graph G;
    private Digraph DG;// 图

    //根据filename指定的文件构造图，使用delim来分割顶点名
    public SymbolGraph(String filename,String delim){
        st = new HashMap<String,Integer>();   //第一遍
        st.put(new String(),st.size());    //为每个字符串关联一个索引
        keys = new String[st.size()];
        for(String name : st.keySet())
            keys[st.get(name)] = name;
        G = new Graph(st.size());            //第二遍   构造图
        int v = st.get(0);
        for(int i = 0; ;i++){

        }

    }
    //key是一个顶点吗
    public boolean contains(String key){
        return st.containsKey(key);
    }
    //key的索引
    public int index(String key){
        return st.get(key);
    }
    //索引v的顶点名
    public String name(int v){
        return keys[v];
    }
    //隐藏的Graph对象
    public Graph G(){
        return G;
    }
    public Digraph DG(){
        return DG;
    }
}
