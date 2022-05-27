package com.example.springweb.dto;

import com.example.springweb.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Data

public class CostumerUserDeital implements UserDetails {
    @Autowired
        UserEntity userEmtity;
   public CostumerUserDeital (UserEntity us){
       userEmtity=us;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        List<String>roles=new ArrayList<>();
        userEmtity.getRoleEntities().forEach(role->{
            list.add(new SimpleGrantedAuthority(role.getName()));
        });
        return list;
    }

    @Override
    public String getPassword() {
        return userEmtity.getPassWord();
    }

    @Override
    public String getUsername() {
        return userEmtity.getUserName();
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
