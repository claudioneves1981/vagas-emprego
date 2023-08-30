package com.vagasemprego.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(cascade={ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(
            name = "TB_USUARIO_VAGAS",
            joinColumns = @JoinColumn(name="ID_USUARIO",
                    referencedColumnName = "ID_USUARIO"),
            inverseJoinColumns = @JoinColumn(name = "ID_VAGAS",
                    referencedColumnName ="ID_VAGAS")
    )
    private Vagas vagas;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tab_user_roles", joinColumns = @JoinColumn(name= "user_id"))
    @Column(name = "role_id")
    private List<String> roles = new ArrayList<>();

}
