package com.etude_de_cas.edc.service;

import com.etude_de_cas.edc.model.Notification;
import com.etude_de_cas.edc.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification creerNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public List<Notification> getNotificationsParUtilisateur(Long utilisateurId) {
        return notificationRepository.findAll()
                .stream()
                .filter(n -> n.getUtilisateur().getId().equals(utilisateurId))
                .toList();
    }
}
