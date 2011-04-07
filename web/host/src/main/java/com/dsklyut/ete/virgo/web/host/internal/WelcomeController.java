package com.dsklyut.ete.virgo.web.host.internal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: dsklyut
 * Date: 4/7/11
 * Time: 3:14 PM
 */
@Controller
public class WelcomeController {
    @RequestMapping(value = "/welcome", method = {RequestMethod.GET})
    public void welcome() {
        // do nothing
    }
}
