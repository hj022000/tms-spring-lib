package com.taomee.bigdata.io;

/**
 * Created by looper on 2017/5/23.
 */
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
public final class Calculator {
    private final static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
    public static Object cal(String expression) throws ScriptException{
        return jse.eval(expression);
    }
}
