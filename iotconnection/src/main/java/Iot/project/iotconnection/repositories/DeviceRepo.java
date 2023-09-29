package Iot.project.iotconnection.repositories;

import Iot.project.iotconnection.models.Device;
import Iot.project.iotconnection.models.User;
import Iot.project.iotconnection.models.UserDevice;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface DeviceRepo extends CrudRepository<Device, Long> {
    public Device findById(long id);

    public Device findBytoken(String token);

    Device findByTopic(String topic);
}