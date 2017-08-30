package com.sda.bank;

/**
 * Created by Szymon on 2017-08-30.
 */
public class AccountFactory {

    private static Integer counter = 0;

    public static Account createAccount(Integer userId) {
        return new Account(counter++, 0, userId);
    }

    public static Account createAccount() {
        return new Account(counter++, 0);
    }

    public static void clearIndex() {
        counter = 0;
    }
}
