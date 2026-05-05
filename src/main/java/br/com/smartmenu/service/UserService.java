package br.com.smartmenu.service;

import br.com.smartmenu.dto.UserDTO;
import br.com.smartmenu.entities.User;
import br.com.smartmenu.exceptions.BadRequestException;
import br.com.smartmenu.exceptions.NotFoundException;
import br.com.smartmenu.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository repository;

    public List<User> findAll() {
        return repository.findAll();

    }

    public List<User> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public User createUser(UserDTO dto) throws BadRequestException {
        User user = new User(dto);
        User user1 = repository.findByEmail(dto.getEmail())
                .orElse(null);
        if (user1 != null) {
            throw new BadRequestException("This user already exists with this email address");
        }

        return repository.save(user);

    }

    public User updateUser(Long id, UserDTO dto) {

        User user = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found!!"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        user.setLastChangeDate(dto.getLastChangeDate());

        return repository.save(user);
    }

    public void deleteUser(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found!!"));

        repository.delete(user);

    }
}
