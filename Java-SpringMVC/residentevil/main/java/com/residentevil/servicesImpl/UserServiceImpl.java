package com.residentevil.servicesImpl;


import com.residentevil.entities.User;
import com.residentevil.models.bindingModels.RegisterModel;
import com.residentevil.repositories.UserRepository;
import com.residentevil.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findOneByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid Credentials");
        }
        return user;
    }

    @Override
    public void register(RegisterModel registerModel) {
        User user = this.modelMapper.map(registerModel, User.class);
        String encryptedPass = bCryptPasswordEncoder.encode(registerModel.getPassword());
        user.setPassword(encryptedPass);

        this.userRepository.save(user);
    }
}
