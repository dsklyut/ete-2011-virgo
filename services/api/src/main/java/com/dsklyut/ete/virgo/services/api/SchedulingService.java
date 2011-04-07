package com.dsklyut.ete.virgo.services.api;

import com.dsklyut.ete.virgo.jpa.model.Presentation;
import com.dsklyut.ete.virgo.jpa.model.PresentationType;
import com.dsklyut.ete.virgo.jpa.model.Speaker;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * User: dsklyut
 * Date: 4/6/11
 * Time: 3:44 PM
 */
public interface SchedulingService {

    class SpeakerInfo implements Serializable {
        private final String firstName;
        private final String lastName;
        private final String email;
        private final String bio;


        public SpeakerInfo(String firstName, String lastName, String email) {
            this(firstName, lastName, email, null);
        }

        public SpeakerInfo(String firstName, String lastName, String email, String bio) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.bio = bio;
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

        public String getBio() {
            return bio;
        }
    }

    class PresentationInfo implements Serializable {

        private final String title;
        private final String description;
        private final Date presentationDate;
        private final Date presentationTime;
        private final PresentationType type;


        public PresentationInfo(String title, String description) {
            this(title, description, PresentationType.UNKNOWN);
        }

        public PresentationInfo(String title,
                                String description,
                                PresentationType type) {
            this(title, description, type, null, null);
        }

        public PresentationInfo(String title,
                                String description,
                                PresentationType type,
                                Date presentationDate,
                                Date presentationTime) {
            this.title = title;
            this.description = description;
            this.type = type;

            this.presentationDate = presentationDate;
            this.presentationTime = presentationTime;
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
    Presentation schedulePresentation(String title, String description, SpeakerInfo... speakers);
}
