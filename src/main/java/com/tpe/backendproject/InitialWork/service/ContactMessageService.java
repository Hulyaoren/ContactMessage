package com.tpe.backendproject.InitialWork.service;

import com.tpe.backendproject.InitialWork.dto.ContactMessageRequest;
import com.tpe.backendproject.InitialWork.dto.ContactMessageResponse;
import com.tpe.backendproject.InitialWork.entity.ContactMessage;
import com.tpe.backendproject.InitialWork.mapper.ContactMessageMapper;
import com.tpe.backendproject.InitialWork.payload.messages.SuccessMessages;
import com.tpe.backendproject.InitialWork.payload.response.ResponseMessage;
import com.tpe.backendproject.InitialWork.repository.ContactMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor //Generates a constructor with required arguments. Required arguments are final fields
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;
    private final ContactMessageMapper contactMessageMapper;

    public List<ContactMessage> getAll() {
        return contactMessageRepository.findAll();
    }

    public ResponseMessage<ContactMessageResponse> save(ContactMessageRequest contactMessageRequest) {

        ContactMessage contactMessage = contactMessageMapper.mapContactMessageRequestToContactMessage(contactMessageRequest);
        ContactMessage savedContactMessage = contactMessageRepository.save(contactMessage);
        return ResponseMessage.<ContactMessageResponse>builder()
                .message(SuccessMessages.CONTACT_MESSAGE_CREATE)
                .httpStatus(HttpStatus.CREATED)
                .returnBody(contactMessageMapper.mapContactMessageToContactMessageResponse(savedContactMessage))
                .build();



    }

    public Page<ContactMessageResponse> getAllByPage(int page, int size, String sort, String type) {

        Pageable pageable = PageRequest.of(page,size, Sort.by(sort).ascending());
        if(type.equals("desc")){
            pageable = PageRequest.of(page,size, Sort.by(sort).descending());
        }
        return contactMessageRepository.findAll(pageable)
                .map(contactMessageMapper::mapContactMessageToContactMessageResponse);

    }

    public List<ContactMessageResponse> getByEmail(String email) {
        List<ContactMessage> contactMessages = contactMessageRepository.findByEmail(email);
        return contactMessages.stream()
                .map(contactMessageMapper::mapContactMessageToContactMessageResponse)
                .collect(Collectors.toList());
    }
}
