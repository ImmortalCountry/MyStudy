package com.sdy.test;

/**
 * @author: SunDeYu
 * @date: 2020/8/31 14:44
 * @description:
 * 1. 无论合适都会执行 finally 语句，且在 try catch 语句之后执行。
 * 2. 以 finally 中 return 语句为准。但是不建议加在 finally 中。
 * 3. 最后执行 finally 语句
 * 4. 出现一场 try 中的 return 不生效。
 * 5. catch 中没有返回语句需要在方法最后加返回值。且 catch 不返回则继续执行 try catch 后的语句。
 * 6. try 中的 return 不起作用。m
 * 7. return 只执行一次，且 try 中
 * 8. 若发生异常，try 中 return 不生效，也不执行。
 * 9. 若 try 中无异常，那么若 try 中有返回值，返回 try 的返回值。
 * 10. try 中有异常才会走下边的逻辑(try catch 外面的语句,因为无异常 try 块中已经 return 了)
 */
public class TryCatchTest {
    public static void main(String[] args) {
        System.out.println(test());
    }

    private static String test(){
        String number  = "0" ;
        try {
            System.out.println("我进入 try 语句啦！");
            int a = 10/0;
            System.out.println("我执行完 try 语句啦！");
            return "来自 try 代码块";
//            return String.valueOf(Integer.parseInt(number)+1);
        }
        catch (Exception e){
            System.out.println("我进入 catch 语句啦！");
            e.printStackTrace();
//            return "来自 catch 代码块";
//            return String.valueOf(Integer.parseInt(number)+1);
        }
        finally {
            System.out.println("我进入 finally 语句啦！");
//            return "来自 finally 代码块";
//        return String.valueOf(Integer.parseInt(number)+1);
        }
        System.out.println("我在 try catch 外面啦！");
//        return "我来自 test";
        return String.valueOf(Integer.parseInt(number)+1);
    }

}
