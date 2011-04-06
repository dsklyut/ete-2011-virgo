package com.dsklyut.ete.virgo.services.api;

import com.dsklyut.ete.virgo.jpa.model.Attendee;

import java.util.Set;

/**
 * User: dsklyut
 * Date: 4/6/11
 * Time: 3:42 PM
 */
public interface RegistrationService {

    /**
     * @param firstName
     * @param lastName
     * @param email
     * @return
     */
    Attendee register(String firstName, String lastName, String email);

}
