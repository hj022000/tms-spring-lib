package com.taomee.bigdata.OOM;

/**
 * Author looper.
 * Company  TaoMee.Inc, ShangHai.
 * Date  2017/6/15.
 */
public class JavaVMStackSOF {
    /**
     * -Xss128k
     *
     * Exception in thread "main" java.lang.StackOverflowError
     */
    private int stackLength = 1;
    public void statckLeak()
    {
        stackLength++;
        statckLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.statckLeak();
        } catch (Exception e) {
            System.out.println("---" + oom.stackLength);
            e.printStackTrace();
        }
    }
}
