package co.istad.springsecuritybasic.repository;


import co.istad.springsecuritybasic.model.Authority;
import co.istad.springsecuritybasic.model.Role;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;

    @PostConstruct
    void initData(){
        initAuthorities();
        initRoles();
    }

    private void initAuthorities(){
        List<String> authorities = List.of("READ","WRITE","DELETE");
        if(authorityRepository.count() == 0)
            for(String auth: authorities){
                Authority authority = new Authority();
                authority.setName(auth);
                authorityRepository.save(authority);
            }
    }
    private void initRoles(){
        if(roleRepository.count() == 0){
            Role userRole = new Role();
            userRole.setName("USER");
             userRole.setAuthorities(Set.of(authorityRepository.findByName("READ").get()));
            roleRepository.save(userRole);

            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            adminRole.setAuthorities(new HashSet<>(authorityRepository.findAll()));
            roleRepository.save(adminRole);
        }


    }


}
