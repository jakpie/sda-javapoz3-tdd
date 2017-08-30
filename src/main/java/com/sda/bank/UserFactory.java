package com.sda.bank;

/**
 * Created by Szymon on 2017-08-30.
 */
public class UserFactory {

    private static Integer counter = 0;

    public static User createNewUser(String firstName, String lastName) {
        return new User(counter++, firstName, lastName);
    }
}
