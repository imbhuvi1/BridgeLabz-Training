package com.contacts.app.service;

import com.contacts.app.dto.ContactRequestDTO;
import com.contacts.app.dto.ContactResponseDTO;
import com.contacts.app.entity.Contact;
import com.contacts.app.exception.ContactNotFoundException;
import com.contacts.app.mapper.ContactMapper;
import com.contacts.app.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{

    private final ContactRepository contactRepository;

    private final ContactMapper contactMapper;

    @Override
    public List<ContactResponseDTO> getAllContacts(){
        return contactRepository.findAll()
                .stream()
                .map(contactMapper::toResponseDTO) //WHY
                .toList();
    }

    @Override
    public ContactResponseDTO getContactById(Long id){
        Contact contact = contactRepository.findById(id).orElseThrow(
                ()->new ContactNotFoundException(id)
        );
        return contactMapper.toResponseDTO(contact);
    }

    @Override
    public ContactResponseDTO createContact(ContactRequestDTO requestDTO){
        Contact contact = contactMapper.toEntity(requestDTO);
        Contact savedContact = contactRepository.save(contact);
        return contactMapper.toResponseDTO(savedContact);
    }

    @Override
    public ContactResponseDTO updateContact(Long id,ContactRequestDTO requestDTO){
        Contact existingContact = contactRepository.findById(id).orElseThrow(
                ()->new ContactNotFoundException(id)
        );
        existingContact.setName(requestDTO.getName());
        existingContact.setEmail(requestDTO.getEmail());
        existingContact.setPhone(requestDTO.getPhone());

        Contact updatedContact = contactRepository.save(existingContact);
        return contactMapper.toResponseDTO(updatedContact);
    }

    @Override
    public void deleteContact(Long id){
        if(!contactRepository.existsById(id)){
            throw new ContactNotFoundException(id);
        }
        contactRepository.deleteById(id);
    }
}
