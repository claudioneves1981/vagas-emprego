package com.vagasemprego.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "PASSWORD")
    private String password;

    //@OneToMany(cascade=CascadeType.ALL)
    //@JoinTable(
   //         name="TB_VAGAS_USUARIO",
   //         joinColumns = @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO"),
   //         inverseJoinColumns = @JoinColumn(name = "ID_VAGAS",referencedColumnName = "ID_VAGAS")
   // )
    //private List<Vagas> vagas;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
        this.role = Role.USER;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario user = (Usuario) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    public enum Role {
        ADMIN,
        USER
    }

}
