package com.gamestore.gamestore.security;

import com.gamestore.gamestore.model.Usuario;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private String userName;
    private String password;

    private List<GrantedAuthority> authorities;

    public UserDetailsImpl(Usuario usuario) {
        this.userName = usuario.getEmail();
        this.password = usuario.getSenha();
    }

    public UserDetailsImpl(){}
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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

    @Override
    public boolean isEnabled() {
        return true;
    }
}
