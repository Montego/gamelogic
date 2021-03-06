package service.impl;

import entity.Password;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PasswordRepository;
import service.IPasswordService;

@Service
@Slf4j
public class PasswordService implements IPasswordService {

    private PasswordRepository passwordRepository;

    @Autowired
    public PasswordService(PasswordRepository passwordRepository) {
        this.passwordRepository = passwordRepository;
    }

    @Override
    public Password addPassword(Password password) {
        passwordRepository.save(password);
        log.info("New password saved with id {}", password.getId());
        return password;
        //return passwordRepository.save(password);
    }

    public Password changePassword(Password password) {
        return null;
    }
}
