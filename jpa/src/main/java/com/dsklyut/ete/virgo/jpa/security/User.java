package com.dsklyut.ete.virgo.jpa.security;

/**
 * User: dsklyut
 * Date: 4/6/11
 * Time: 10:53 AM
 */
public final class User {

    private final String userName;
    private final String fullName;

    public User(String userName, String fullName) {
        this.userName = userName;
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }
}
