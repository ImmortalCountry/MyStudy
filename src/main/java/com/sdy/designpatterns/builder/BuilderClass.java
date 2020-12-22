package com.sdy.designpatterns.builder;

import com.google.common.base.Strings;

/**
 * @author: sundy
 * @date: 2020/12/22 09:58
 * @description:
 */
public class BuilderClass {
    private String id;
    private String name;
    private String sex;
    private int amount = 10;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAmount() {
        return amount;
    }

    public BuilderClass(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.sex = builder.sex;
        this.amount = builder.amount;
    }

    public static class Builder {
        private String id;
        private String name;
        private String sex;
        private int amount = 10;

        public BuilderClass build() {
            if (Strings.isNullOrEmpty(id)) {
                throw new IllegalArgumentException("id can't null");
            }
            if (Strings.isNullOrEmpty(name)) {
                throw new IllegalArgumentException("name can't null");
            }
            return new BuilderClass(this);
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder setAmount(int amount) {
            this.amount = amount;
            return this;
        }
    }
}
