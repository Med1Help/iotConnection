package Iot.project.iotconnection.repositories;
import Iot.project.iotconnection.models.Links;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.List;
public interface LinksRepo extends CrudRepository<Links,Long>{
   public List<Links> findLinksBytopic(String topic);
}
