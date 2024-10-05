package com.tpe.backendproject.InitialWork.mapper;

import com.tpe.backendproject.InitialWork.dto.ContactMessageRequest;
import com.tpe.backendproject.InitialWork.dto.ContactMessageResponse;
import com.tpe.backendproject.InitialWork.entity.ContactMessage;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ContactMessageMapper {

    public ContactMessage mapContactMessageRequestToContactMessage(ContactMessageRequest contactMessageRequest){

        return ContactMessage.builder()
                .name(contactMessageRequest.getName())
                .email(contactMessageRequest.getEmail())
                .subject(contactMessageRequest.getSubject())
                .message(contactMessageRequest.getMessage())
                .dateTime(LocalDateTime.now())
                .build();
    }

    public ContactMessageResponse mapContactMessageToContactMessageResponse(ContactMessage contactMessage){
        return ContactMessageResponse.builder()
                .name(contactMessage.getName())
                .email(contactMessage.getEmail())
                .subject(contactMessage.getSubject())
                .message(contactMessage.getMessage())
                .dateTime(LocalDateTime.now())
                .build();
    }

}
