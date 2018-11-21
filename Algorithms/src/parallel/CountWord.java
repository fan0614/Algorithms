package parallel;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CountWord {
    final static String SENTENCE = " Nel  mezzo del cammin di nostra vita "+"mi ritrovai in una selva oscura"+" che la dritta via era smarrita ";
    public static int countWordIteratively(String s){
        int counter = 0;
        boolean lastSpace = true;
        for(char c : s.toCharArray()){
            if(Character.isWhitespace(c)){
                lastSpace = true;
            }
            else {
             if(lastSpace) counter++;
             lastSpace = false;
            }
        }
        return  counter;
    }
    public static void main(String[] args){
        System.out.println(countWordIteratively(SENTENCE));
        Stream<Character> stream = IntStream.range(0,SENTENCE.length())
                .mapToObj(SENTENCE::charAt);
        System.out.println(WordCounter.countWords(stream.parallel()));
        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream2 = StreamSupport.stream(spliterator,true);
        System.out.println(WordCounter.countWords(stream2.parallel()));
     }
}
