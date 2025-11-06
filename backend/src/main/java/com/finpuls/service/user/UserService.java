package com.finpuls.service.user;

import com.finpuls.domain.model.user.User;
import com.finpuls.domain.model.user.UserStatus;
import com.finpuls.domain.repository.UserRepository;
import com.finpuls.service.common.AbstractCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService extends AbstractCrudService<User, UUID> {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        super(User.class, repository);
        this.repository = repository;
    }


    @Transactional
    public User create(String clientId, UUID subscriptionId, UserStatus status){
        User user = new User();
        user.setClientId(clientId);
        user.setSubscriptionId(subscriptionId);
        if (status != null) 
            user.setStatus(status);
        return user;
    }

    @Transactional(readOnly = true)
    public Optional<User> findByClientId(String clientId){
        return repository.findByClientId(clientId);
    }

    @Transactional(readOnly = true)
    public boolean existsByClientId(String clientId){
        return repository.existsByClientId(clientId);
    }

    @Transactional(readOnly = true)
    public List<User> findAllByStatus(UserStatus status){
        return findAllByField("status", status);
    }
}
