package com.retoBCP.userAPI.controller;

import com.retoBCP.userAPI.models.NotificationType;
import com.retoBCP.userAPI.models.UserNotificationSubscription;
import com.retoBCP.userAPI.service.UserNotificationSubsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
    @RequestMapping("/user-subscriptions")
public class UserNotificationSubsController {

    @Autowired
    private final UserNotificationSubsService userNotificationSubsService;
    
    RestTemplate restTemplate = new RestTemplate();

    public UserNotificationSubsController(UserNotificationSubsService userNotificationSubsService) {
        this.userNotificationSubsService = userNotificationSubsService;
    }

    @GetMapping
    public List<UserNotificationSubscription> getAllNotifications(){
        return userNotificationSubsService.getAllSubscriptions();
    }
    @GetMapping("/{id}")
    public List<UserNotificationSubscription> getSubscriptionsForUser(@PathVariable Integer id){
        return userNotificationSubsService.getByUserId(id);
    }
    @PostMapping("/all/{id}")
    public void addSubscriptions(@PathVariable Integer id){

        ResponseEntity<NotificationType[]> responseEntity = restTemplate.getForEntity("https://reto-bcp.herokuapp.com/api/v1/notificationTypes", NotificationType[].class);
        NotificationType[] notifs = responseEntity.getBody();


        userNotificationSubsService.addAllSubscriptions(id, notifs);
    }
    @PostMapping()
    public void addSubscription(@RequestBody UserNotificationSubscription object){

        userNotificationSubsService.save(object);
    }
    @DeleteMapping
    public  ResponseEntity<UserNotificationSubscription> deleteSubscription(@RequestBody UserNotificationSubscription object){

        userNotificationSubsService.delete( object);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
