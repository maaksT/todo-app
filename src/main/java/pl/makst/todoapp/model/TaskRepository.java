package pl.makst.todoapp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> findAll();
    Page<Task> findAll(Pageable pageable);
    Optional<Task> findById(Integer i);
    Task save(Task entity);
    boolean existsById(Integer id);
    boolean existsByDoneIsFalseAndGroupId(Integer groupId);
    List<Task> findByDone(boolean done);

}
