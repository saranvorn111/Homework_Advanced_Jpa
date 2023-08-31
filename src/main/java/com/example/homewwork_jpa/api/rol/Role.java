package com.example.homewwork_jpa.api.rol;

import com.example.homewwork_jpa.api.user.UserRole;
import com.example.homewwork_jpa.api.authorities.Authority;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles;

    @ManyToMany
    @JoinTable(name = "role_authorities",
    joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "authorities_id",referencedColumnName = "id"))
    private List<Authority> authorities;
}
