package com.example.demo.service;


import com.example.demo.dao.RoleRepository;
import com.example.demo.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findByRole(String name) {
        return roleRepository.findByRole(name);
    }

    @Override
    public HashSet<Role> getSetOfRoles(Integer[] roleNames) {
        Set<Role> roleSet = new HashSet<>();
        for (Integer role : roleNames) {
            roleSet.add(findById(role));
        }
        return (HashSet) roleSet;
    }

    @Override
    public Role findById(int id) {
        return roleRepository.findById(id).get();
    }
}
