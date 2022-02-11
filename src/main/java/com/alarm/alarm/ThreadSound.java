package com.alarm.alarm;

public class ThreadSound{
    public static class MyThread extends Thread {
        @Override
        public void run() {
           /* if (target != null) {
                target.run();
            }
        }*/

        }
    }

    public static void main(String []args){
        Thread thread = new MyThread();
        thread.start();
    }
}