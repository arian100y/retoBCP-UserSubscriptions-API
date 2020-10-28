package com.retoBCP.userAPI.service;

import com.retoBCP.userAPI.models.NotificationType;
import com.retoBCP.userAPI.models.UserNotificationSubscription;
import com.retoBCP.userAPI.repository.UserNotificationSubsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserNotificationSubsService {

    @Autowired
    private UserNotificationSubsRepository userNotificationSubsRepository;

    public List<UserNotificationSubscription> getAllSubscriptions(){
        List<UserNotificationSubscription> userNotificationSubscriptions = new ArrayList<>();
        userNotificationSubsRepository.findAll().forEach( userNotificationSubscriptions::add);
        return userNotificationSubscriptions;
    }

    public void addAllSubscriptions(Integer id, NotificationType[] notifs){

        for (int i = 0; i < notifs.length; i++) {

            userNotificationSubsRepository.save(new UserNotificationSubscription(id,
                    notifs[i].getId()));
        }
    }
    public List<UserNotificationSubscription> getByUserId(Integer id){
        return userNotificationSubsRepository.getByUserId(id);
    }
    public void delete(UserNotificationSubscription object){
        System.out.println(object.getUser_id()+"  " +object.getNotificationType_id());
        userNotificationSubsRepository.deleteWithoutId(object.getUser_id(),object.getNotificationType_id());
    }
    public void save(UserNotificationSubscription object){
        userNotificationSubsRepository.save(object);
    }
}
