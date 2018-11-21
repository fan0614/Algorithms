package testjd;
import java.util.HashMap;
import java.util.Scanner;

public class test2{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            HashMap<Integer,String> map = new HashMap<>();
            int i = 1;
            while(sc.hasNext())
            {
                map.put(++i,sc.next());
            }
            MinNumber(s,map);
        }
        public static void MinNumber(String s,HashMap map)
        {
            char[] chs = s.toCharArray();
            int k = 0;
            for(int i=1;map.containsKey(i);i++)
            {
                if(((String)map.get(i)).length()==s.length())
                {
                    char[] ch = ((String) map.get(i)).toCharArray();
                    int n = 0;
                    for(int j=0;j<s.length();j++)
                    {
                        if(ch[j]!=chs[j])
                        {
                            n++;
                        }
                    }
                    if (n==0) {
                        System.out.print(((String) map.get(i)) + ' ');
                        k++;
                        if(k==3) break;
                    }
                    for(int j=0;j<s.length();j++)
                    {
                        if(ch[j]!=chs[j])
                        {
                            n++;
                        }
                    }
                    if (n==1) {
                        System.out.print(((String) map.get(i)) + ' ');
                        k++;
                        if(k==3) break;
                    }
                }

            }
        }
    }

