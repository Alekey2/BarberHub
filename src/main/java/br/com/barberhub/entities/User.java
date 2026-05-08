package br.com.barberhub.entities;

import br.com.barberhub.dto.UserDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private String name;

    @Column(unique = true, nullable = true)
    private String email;
    @Column(nullable = true)
    private String login;
    @Column(nullable = true)
    private String password;

    @Column(name = "last_change_date",nullable = true)
    private LocalDateTime lastChangeDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id")
    private Address address;

    public User() {
    }

    public User(UserDTO dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.login = dto.getLogin();
        this.password = dto.getPassword();
        this.lastChangeDate = dto.getLastChangeDate();
    }

    public User(Long id, String name, String email, String login, String password, LocalDateTime lastChangeDate, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
        this.lastChangeDate = lastChangeDate;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(LocalDateTime lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
