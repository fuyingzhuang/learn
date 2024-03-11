package com.ambition.JVMDemo;

/**
 * @author Ambition
 * @date 2024/3/11 21:23
 * 逃逸分析
 * <p>
 * 如何快速的判断是否发生了逃逸分析 就看new的对象是否有可能在方法外被调用
 */
public class EscapeAnalysis {
    public EscapeAnalysis obj;

    /**
     * 方法返回EscapeAnalysis对象，发生逃逸
     */
    public EscapeAnalysis getInstance() {
        return obj == null ? new EscapeAnalysis() : obj;
    }

    /**
     * 为成员属性赋值，发生逃逸
     */
    public void setObj() {
        this.obj = new EscapeAnalysis();
    }

    // 思考：如果当前的obj声明为static的，会发生逃逸吗？
    // public static void setObj() {
    //     this.obj = new EscapeAnalysis();
    // }


    /**
     * 对象的作用域仅在当前的方法中 无发生逃逸
     */
    public void useEscapeAnalysis() {
        EscapeAnalysis e = new EscapeAnalysis();
    }

    /**
     * 引用成员变量的值，发生逃逸
     */
    public void useEscapeAnalysis1() {
        EscapeAnalysis e = getInstance();
    }

}
