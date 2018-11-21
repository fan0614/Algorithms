package string.stringsort;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KeyIndexCount {
    private int N;
    private Student[] aux;
    private int[] count;
    Set<Integer> set = new HashSet<>();

    public KeyIndexCount(Student[] a){
        for(Student map:  a)
            if(set.contains(map.key)) continue;
            else set.add(map.key);
        int R = set.size()+1;
        N = a.length;
        aux = new Student[N];
        count = new int[R+1];
        //计算出现的频率
        for(int i = 0;i<N;i++)
            count[a[i].key+1]++;
        //将频率转化为索引
        for(int r = 0;r<R;r++){
            count[r+1] += count[r];
        }
        //将元素分类
        for(int i = 0; i < N;i++){
            aux[count[a[i].key]++] = a[i];
        }
        //回写
        for(int i = 0; i < N;i++){
            a[i] = aux[i];
        }
    }
    private static class Student{
        private int key;
        private String name;

        public Student(int key, String name) {
            this.key = key;
            this.name = name;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
