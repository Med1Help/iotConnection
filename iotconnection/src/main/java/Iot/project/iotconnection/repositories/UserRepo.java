package Iot.project.iotconnection.repositories;

import Iot.project.iotconnection.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
@Transactional
public interface UserRepo extends CrudRepository<User, Long> {
    public User findUserByemail(String email);
    public User findUserByemailAndPassword(String email , String password);

    public void deleteByNameAndEmail(String name,String email);
}
