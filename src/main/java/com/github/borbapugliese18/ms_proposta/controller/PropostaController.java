// Gabriel Borba Pugliese Ribeiro - RM94677
// Pedro De Sousa Dutra - RM96167
package com.github.borbapugliese18.ms_proposta.controller;

import com.github.borbapugliese18.ms_proposta.dto.PropostaDTO;
import com.github.borbapugliese18.ms_proposta.dto.PropostaRequestDTO;
import com.github.borbapugliese18.ms_proposta.dto.PropostaResponseDTO;
import com.github.borbapugliese18.ms_proposta.dto.UserDTO;
import com.github.borbapugliese18.ms_proposta.services.PropostaService;
import com.github.borbapugliese18.ms_proposta.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(value = "/propostas")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    // Create
    @PostMapping
    public ResponseEntity<PropostaResponseDTO> insert(@Valid @RequestBody PropostaRequestDTO propostaRequestDTO) {
        PropostaResponseDTO createdProposta = propostaService.insert(propostaRequestDTO);
        return ResponseEntity.ok(createdProposta);
    }

    // Read All com Paginação
    @GetMapping
    public ResponseEntity<Page<PropostaResponseDTO>> findAll(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size,
            @RequestParam Optional<String> sortBy) {
        Pageable pageable = PageRequest.of(
                page.orElse(0),
                size.orElse(10),
                Sort.Direction.ASC, sortBy.orElse("id")
        );
        Page<PropostaResponseDTO> propostas = propostaService.findAll(pageable);
        return ResponseEntity.ok(propostas);
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<PropostaResponseDTO> findById(@PathVariable Long id) {
        Optional<PropostaResponseDTO> propostaOpt = propostaService.findById(id);
        return propostaOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<PropostaResponseDTO> update(@PathVariable Long id, @Valid @RequestBody PropostaRequestDTO propostaRequestDTO) {
        PropostaResponseDTO updatedProposta = propostaService.update(id, propostaRequestDTO);
        return ResponseEntity.ok(updatedProposta);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        propostaService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
