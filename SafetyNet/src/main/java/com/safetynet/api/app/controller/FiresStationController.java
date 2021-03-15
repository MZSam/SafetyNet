package com.safetynet.api.app.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class FiresStationController {
	@RequestMapping("/findbynb/{nb}")
	@ResponseBody
    public String findByNb(@PathVariable("nb") int nb) {
        return "Firestation_Nb";
    }

}
