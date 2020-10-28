package com.retoBCP.userAPI.repository;

import com.retoBCP.userAPI.models.UserNotificationSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserNotificationSubsRepository extends JpaRepository<UserNotificationSubscription,Integer> {

    @Query(value = "SELECT * FROM usuario_notificacion_subscripcion u WHERE u.user_id = :id ",
            nativeQuery = true)
    List<UserNotificationSubscription> getByUserId(
            @Param("id") Integer id);

    @Query(value = "DELETE * FROM usuario_notificacion_subscripcion u WHERE u.user_id = :uid AND u.notificationType_id = :nid",
            nativeQuery = true)
    void deleteWithoutId(
            @Param("uid") Integer uid,@Param("nid") Integer nid);
}
