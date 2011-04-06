package com.dsklyut.ete.virgo.services.api;

import com.dsklyut.ete.virgo.jpa.model.Presentation;
import com.dsklyut.ete.virgo.jpa.model.Speaker;

import java.util.Set;

/**
 * User: dsklyut
 * Date: 4/6/11
 * Time: 3:44 PM
 */
public interface SchedulingService {

    class SpeakerInfo {
        private String firstName;
        private String lastName;
        private String email;


        public SpeakerInfo(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }
    }

    /**
     * @return
     */
    Set<Presentation> listPresentations();

    /**
     * @return
     */
    Set<Speaker> listSpeakers();

    /**
     * @param title
     * @param description
     * @param speakers
     * @return
     */
    Presentation registerPresentation(String title, String description, SpeakerInfo... speakers);
}
