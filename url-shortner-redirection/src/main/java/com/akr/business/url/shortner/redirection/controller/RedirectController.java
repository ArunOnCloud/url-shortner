package com.akr.business.url.shortner.redirection.controller;

import com.akr.business.url.shortner.redirection.service.RedirectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    RedirectionService redirectionService;

    @GetMapping("health")
    public ResponseEntity<String> health(){
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }



    @GetMapping("r/{id}")
    public RedirectView redirect(RedirectAttributes attributes,@PathVariable String id){
        String url = redirectionService.getRedirectUrl(id);
        log.info("redirecting key {} to url {}",id,url);
        return new RedirectView(url);

    }

}
