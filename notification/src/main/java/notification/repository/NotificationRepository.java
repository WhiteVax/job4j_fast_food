package notification.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.domain.model.Notification;

import java.util.List;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Integer> {
    List<Notification> findAll();
}
