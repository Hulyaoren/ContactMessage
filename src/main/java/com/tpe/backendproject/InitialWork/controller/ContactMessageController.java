package com.tpe.backendproject.InitialWork.controller;

import com.tpe.backendproject.InitialWork.dto.ContactMessageRequest;
import com.tpe.backendproject.InitialWork.dto.ContactMessageResponse;
import com.tpe.backendproject.InitialWork.entity.ContactMessage;
import com.tpe.backendproject.InitialWork.payload.response.ResponseMessage;
import com.tpe.backendproject.InitialWork.service.ContactMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contactMessages")
@RequiredArgsConstructor
public class ContactMessageController {

    private final ContactMessageService contactMessageService;
    @PostMapping("/save")
    public ResponseMessage<ContactMessageResponse> saveContact(@Valid @RequestBody ContactMessageRequest contactMessageRequest){
        return contactMessageService.save(contactMessageRequest);


    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ContactMessage>> getAll(){
        List<ContactMessage> contactMessages = contactMessageService.getAll();
        return ResponseEntity.ok(contactMessages);
    }

    @GetMapping("/getAllByPage")
    public ResponseEntity<Page<ContactMessageResponse>> getAllByPage(
            @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size,
            @RequestParam(value = "sort",defaultValue = "name") String sort,
            @RequestParam(value = "type",defaultValue = "desc") String type){
        Page<ContactMessageResponse>contactMessageResponses = contactMessageService.getAllByPage(page,size,sort,type);
        return ResponseEntity.ok(contactMessageResponses);
    }

    @GetMapping("/getByEmail")
    public List<ContactMessageResponse>getByEmail(@RequestParam  String email){
        return contactMessageService.getByEmail(email);
    }





}
