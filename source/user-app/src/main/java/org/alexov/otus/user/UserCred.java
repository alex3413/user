package org.alexov.otus.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Builder
@AllArgsConstructor
@Table(name = "otus_user_cred")
public class UserCred {
    @Id
    @Column(name = "username")
    private String username;
    @OneToOne
    @JoinColumn(name = "user_id")
    private OtusUser user;
    @Column(name = "password")
    private String password;

}
