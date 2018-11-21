package io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {
    public static void main(String[] args) throws IOException{
        PipedOutputStream output = new PipedOutputStream();
        PipedInputStream input = new PipedInputStream(output);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    output.write("hello,pipe".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    int data = input.read();
                    while(data != -1){
                        System.out.print((char)data);
                        data = input.read();
                    }
                }catch (IOException e){

                }
            }
        });

        t1.start();
        t2.start();
    }
}
