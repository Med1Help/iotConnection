package Iot.project.iotconnection.repositories;

import Iot.project.iotconnection.models.Device;
import Iot.project.iotconnection.models.User;
import Iot.project.iotconnection.models.UserDevice;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
@Transactional
public interface USerDeviceRepo extends CrudRepository<UserDevice,Integer> {
  public List<UserDevice> findByidUser(long id_user);
  public UserDevice findByIdDevice(long id_device);

    List<UserDevice> findByUser(User myUser);

  UserDevice findByDevice(Device device);
}
