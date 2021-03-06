package repository;

import entity.Authority;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

    User findByLoginAndRole (String login, Authority role);

    List<User> findByRole(Authority role);


}
