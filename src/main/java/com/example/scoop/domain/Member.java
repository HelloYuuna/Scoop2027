package com.example.scoop.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Data
@Builder
@Entity(name = "Member")
@NoArgsConstructor
public class Member implements UserDetails {
    @Id
    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false)
    private String password;

    @Column (columnDefinition = "number default '1'",
            nullable = false)
    private boolean enabled;                    // 1 or 0

    @Column(columnDefinition = "varchar2(30) default 'ROLE_USER'",
            nullable = false)
    private String role;

    @Builder
    private Member (String email, String password, boolean enabled, String role) {
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * enabled
     * 0 : false 비활성화
     * 1 : true 활성화
     * @return true/false
     */
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
