package com.akr.business.url.shortner.redirection.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("/")
public class RedirectController {


    @GetMapping("health")
    public ResponseEntity<String> health(){
        return new ResponseEntity<String>("OK", HttpStatus.OK);

    }

    @GetMapping("r/{id}")
    public RedirectView redirect(RedirectAttributes attributes,@PathVariable String id){
       // attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
       // attributes.addAttribute("attribute", "redirectWithRedirectView");
        String url = "https://www.google.com/";
        log.info("redirecting key {} to url {}",id,url);
        return new RedirectView(url);

    }

}
