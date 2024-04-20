package co.istad.springsecuritybasic.security;

import co.istad.springsecuritybasic.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
@Setter
@Getter
@NoArgsConstructor
public class CustomUserDetail implements UserDetails {

    private User user;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !user.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !user.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return !user.isEnabled();
    }
}
