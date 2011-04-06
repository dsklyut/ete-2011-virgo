package com.dsklyut.ete.virgo.jpa.security;

/**
 * User: dsklyut
 * Date: 4/6/11
 * Time: 10:55 AM
 */
public final class SecurityHolder {

    private static final ThreadLocal<User> userHolder = new ThreadLocal<User>();

    private SecurityHolder() {
        // static access only
    }

    public static void set(User user) {
        clear();
        userHolder.set(user);
    }

    public static void clear() {
        userHolder.remove();
    }

    public static User currentUser() {
        return userHolder.get();
    }
}
