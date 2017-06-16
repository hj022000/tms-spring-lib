package com.taomee.bigdata.gc;

/**
 * Author looper.
 * Company  TaoMee.Inc, ShangHai.
 * Date  2017/6/16.
 */
public class FinalizeGC {
    public static FinalizeGC SAVE_HOOK = null;

    public void isAlive()
    {
        System.out.println(" i am alive !");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed !");
        FinalizeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Exception {
        SAVE_HOOK = new FinalizeGC();
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null)
        {
            SAVE_HOOK.isAlive();
        }
        else
        {
            System.out.println("no,i am dead !");
        }
    }
}
