package com.github.borbapugliese18.ms_proposta.services;


import com.github.borbapugliese18.ms_proposta.dto.UserDTO;
import com.github.borbapugliese18.ms_proposta.model.User;
import com.github.borbapugliese18.ms_proposta.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO insert(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    public Page<UserDTO> findAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(user -> modelMapper.map(user, UserDTO.class));
    }

    public Optional<UserDTO> findById(Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        return userOpt.map(user -> modelMapper.map(user, UserDTO.class));
    }

    public UserDTO update(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));

        user.setNome(userDTO.getNome());
        user.setCpf(userDTO.getCpf());
        user.setTelefone(userDTO.getTelefone());
        user.setRenda(userDTO.getRenda());

        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserDTO.class);
    }

    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
        userRepository.delete(user);
    }
}



