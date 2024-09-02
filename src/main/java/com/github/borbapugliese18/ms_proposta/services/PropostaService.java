// Gabriel Borba Pugliese Ribeiro - RM94677
// Pedro De Sousa Dutra - RM96167
package com.github.borbapugliese18.ms_proposta.services;

import com.github.borbapugliese18.ms_proposta.dto.PropostaRequestDTO;
import com.github.borbapugliese18.ms_proposta.dto.PropostaResponseDTO;
import com.github.borbapugliese18.ms_proposta.model.Proposta;
import com.github.borbapugliese18.ms_proposta.model.User;
import com.github.borbapugliese18.ms_proposta.repository.PropostaRepository;
import com.github.borbapugliese18.ms_proposta.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public PropostaResponseDTO insert(PropostaRequestDTO propostaRequestDTO) {

        User user = userRepository.findByCpf(propostaRequestDTO.getUser().getCpf())
                .orElseGet(() -> {

                    User newUser = modelMapper.map(propostaRequestDTO.getUser(), User.class);
                    return userRepository.save(newUser);
                });


        Proposta proposta = modelMapper.map(propostaRequestDTO, Proposta.class);
        proposta.setUser(user);

        Proposta savedProposta = propostaRepository.save(proposta);
        return modelMapper.map(savedProposta, PropostaResponseDTO.class);
    }

    public Page<PropostaResponseDTO> findAll(Pageable pageable) {
        Page<Proposta> propostas = propostaRepository.findAll(pageable);
        return propostas.map(proposta -> {
            PropostaResponseDTO dto = modelMapper.map(proposta, PropostaResponseDTO.class);
            dto.setUserId(proposta.getUser().getId());
            return dto;
        });
    }

    public Optional<PropostaResponseDTO> findById(Long id) {
        Optional<Proposta> propostaOpt = propostaRepository.findById(id);
        return propostaOpt.map(proposta -> {
            PropostaResponseDTO dto = modelMapper.map(proposta, PropostaResponseDTO.class);
            dto.setUserId(proposta.getUser().getId());
            return dto;
        });
    }

    public PropostaResponseDTO update(Long id, PropostaRequestDTO propostaRequestDTO) {
        Proposta proposta = propostaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proposta não encontrada com o ID: " + id));

        // Atualiza os campos da proposta
        proposta.setValorSolicitado(propostaRequestDTO.getValorSolicitado());
        proposta.setPrazoParaPagamento(propostaRequestDTO.getPrazoParaPagamento());
        // Aprovado não é atualizado aqui

        // Atualiza ou cria o usuário
        User user = userRepository.findByCpf(propostaRequestDTO.getUser().getCpf())
                .orElseGet(() -> {
                    User newUser = modelMapper.map(propostaRequestDTO.getUser(), User.class);
                    return userRepository.save(newUser);
                });
        proposta.setUser(user);

        Proposta updatedProposta = propostaRepository.save(proposta);
        PropostaResponseDTO responseDTO = modelMapper.map(updatedProposta, PropostaResponseDTO.class);
        responseDTO.setUserId(user.getId());
        return responseDTO;
    }

    public void delete(Long id) {
        Proposta proposta = propostaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proposta não encontrada com o ID: " + id));
        propostaRepository.delete(proposta);
    }


}
