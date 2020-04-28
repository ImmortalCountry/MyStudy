package com.sdy.callBack;

import lombok.Data;

/**
 * @author: sundy
 * @date: 2020/4/28 22:24
 * @description:
 */
@Data
public class BookCallBack implements ICallBack {
    private String bookName;
    private String author;

    @Override
    public void execute() {
        this.setBookName("this book");
        this.setAuthor("sundy");
        System.out.println("书：" + this.getBookName() + "\n" + "作者：" + this.getAuthor());
    }
}
