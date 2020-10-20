package com.sdy.fanxing;

/**
 * @author: SunDeYu
 * @date: 2020/8/12 15:52
 * @description:
 */
public class GenericTest<T> {

    public static void main(String[] args) {
        Generic<Integer> generic = new Generic<>(123);
        System.out.println(generic.getKey());
        // System.out.println(generic.getKey()) ==> 123

        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"hello", "world"};
        printArray(intArray);
        printArray(stringArray);
    }

    static class Generic<T> {
        private T key;

        public Generic(T key) {
            this.key = key;
        }

        public T getKey() {
            return key;
        }
    }

    /**
     * 泛型方法
     *
     * @param inputArray
     * @param <E>
     */
    public static <E> void printArray(E[] inputArray) {
        for (E e : inputArray) {
            System.out.println(e);
        }

    }

}
