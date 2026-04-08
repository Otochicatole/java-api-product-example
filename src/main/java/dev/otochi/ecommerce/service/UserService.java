package dev.otochi.ecommerce.service;

import dev.otochi.ecommerce.dto.UserDTO;
import dev.otochi.ecommerce.entity.UserEntity;
import dev.otochi.ecommerce.mapper.UserMapper;
import dev.otochi.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public List<UserDTO> getAll() {
        return mapper.userEntityListToDTOList(repository.findAll());
    }

    public Optional<UserDTO> getById(UUID id) {
        return repository.findById(id).map(mapper::userEntityToDTO);
    }

    public Optional<UserEntity> getByUsername(String username) {
        return repository.findByUsername(username);
    }

    public Optional<UserDTO> getByEmail(String email) {
        return repository.findByEmail(email).map(mapper::userEntityToDTO);
    }

    public UserDTO create(UserEntity user) {
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("this email is already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity saved = repository.save(user);
        return mapper.userEntityToDTO(saved);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
