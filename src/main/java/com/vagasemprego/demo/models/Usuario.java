package com.vagasemprego.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_VAGAS_USUARIO",
            joinColumns = @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO"),
            inverseJoinColumns = @JoinColumn(name = "ID_VAGAS",referencedColumnName = "ID_VAGAS")
    )
    private List<Vagas> vagas;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tab_user_roles", joinColumns = @JoinColumn(name= "user_id"))
    @Column(name = "role_id")
    private List<String> roles = new ArrayList<>();

}
