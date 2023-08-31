package com.example.homewwork_jpa.api.user;

import com.example.homewwork_jpa.api.userAccount.UserAccount;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uuid;
    private String name;
    private String gender;
    private String email;
    private String password;
    private String phoneNumber;
    private String oneSignalId;
    private Boolean isStudent;
    private String studentCardNo;
    private String verifiedCode;
    private Boolean isDeleted;
    private Boolean isVerified;

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles;

    @OneToMany(mappedBy= "user")
    private List<UserAccount> userAccounts;

}
