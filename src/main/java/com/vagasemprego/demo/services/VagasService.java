package com.vagasemprego.demo.services;

import com.vagasemprego.demo.dtos.VagasRequestDTO;
import com.vagasemprego.demo.dtos.VagasResponseDTO;
import com.vagasemprego.demo.exceptions.EntityVagasNotFoundException;
import com.vagasemprego.demo.mappers.VagasMapper;
import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.models.Vagas;
import com.vagasemprego.demo.repositories.VagasRepository;
import com.vagasemprego.demo.security.JWTCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.vagasemprego.demo.utils.ValidationUtil.validateIdOrThrowException;

@Service
public class VagasService {

    private final VagasRepository vagasRepository;
    private final JWTCreator jwtTokenProvider;
    private final SessaoService authService;

    public VagasService(VagasRepository vagasRepository, JWTCreator jwtTokenProvider, SessaoService authService) {
        this.vagasRepository = vagasRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authService = authService;
    }

   /* @Transactional(readOnly = true)
    public List<VagasResponseDTO> findAll() {
        return vagasRepository.findAll()
                .stream()
                .map(VagasMapper::toDto)
                .collect(Collectors.toList());
    }*/

    @Transactional(readOnly = true)
    public List<VagasResponseDTO> findByUser() {
        Usuario currentUser = jwtTokenProvider.getCurrentUser();
        return vagasRepository.findByUsuario(currentUser)
                .stream()
                .map(VagasMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<VagasResponseDTO> findnByUsuarioIdAndSituacao(String situacao) {
        Long userId = jwtTokenProvider.getCurrentUser().getId();
        return vagasRepository.findByUserIdAndSituacao(userId, situacao)
                .stream()
                .map(VagasMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<VagasResponseDTO> findnByUsuarioIdAndInteresse(String interesse) {
        Long userId = jwtTokenProvider.getCurrentUser().getId();
        return vagasRepository.findByUserIdAndInteresse(userId, interesse)
                .stream()
                .map(VagasMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<VagasResponseDTO> findnByUsuarioIdAndContrato(String contrato) {
        Long userId = jwtTokenProvider.getCurrentUser().getId();
        return vagasRepository.findByUserIdAndContrato(userId, contrato)
                .stream()
                .map(VagasMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<VagasResponseDTO> findnByUsuarioIdAndTipo(String tipo) {
        Long userId = jwtTokenProvider.getCurrentUser().getId();
        return vagasRepository.findByUserIdAndTipo(userId, tipo)
                .stream()
                .map(VagasMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public VagasResponseDTO create(VagasRequestDTO vagasDTO) {

        Usuario currentUser = jwtTokenProvider.getCurrentUser();

        Vagas vagasToSave = new Vagas();
        vagasToSave.setUser(currentUser);
        vagasToSave.setVaga(vagasDTO.vaga());
        vagasToSave.setContrato(vagasDTO.contrato());
        vagasToSave.setBeneficios(vagasDTO.beneficios());
        vagasToSave.setEmpresa(vagasDTO.empresa());
        vagasToSave.setInscricao(LocalDateTime.from(Instant.now()));
        vagasToSave.setInteresse(vagasDTO.interesse());
        vagasToSave.setTipo(vagasDTO.tipo());
        vagasToSave.setSalario(vagasDTO.salario());
        vagasToSave.setSituacao(vagasDTO.situacao());
        vagasToSave.setOrigem(vagasDTO.origem());
        vagasToSave.setObservacoes(vagasDTO.observacoes());

        Vagas savedVagas = vagasRepository.save(vagasToSave);

        return VagasMapper.toDto(savedVagas);
    }

    @Transactional
    public VagasResponseDTO update(Long id, VagasRequestDTO vagasDTO) {
        validateIdOrThrowException(id);

        Vagas vagasToSave = vagasRepository.findById(id).orElseThrow(
                () -> new EntityVagasNotFoundException(id));

        authService.validateUserOwnership(vagasToSave.getUser());


        if (vagasDTO != null){
            vagasToSave.setVaga(vagasDTO.vaga());
            vagasToSave.setContrato(vagasDTO.contrato());
            vagasToSave.setBeneficios(vagasDTO.beneficios());
            vagasToSave.setEmpresa(vagasDTO.empresa());
            vagasToSave.setInteresse(vagasDTO.interesse());
            vagasToSave.setTipo(vagasDTO.tipo());
            vagasToSave.setSalario(vagasDTO.salario());
            vagasToSave.setSituacao(vagasDTO.situacao());
            vagasToSave.setOrigem(vagasDTO.origem());
            vagasToSave.setObservacoes(vagasDTO.observacoes());
        }

        Vagas savedVagas = vagasRepository.save(vagasToSave);
        return VagasMapper.toDto(savedVagas);
    }

    @Transactional
    public void delete(Long id) {
        validateIdOrThrowException(id);

        Vagas reservationById =vagasRepository.findById(id).orElseThrow(
                () -> new EntityVagasNotFoundException(id));

        authService.validateUserOwnership(reservationById.getUser());
        vagasRepository.delete(reservationById);
    }




}
