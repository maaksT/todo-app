package pl.makst.todoapp.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.makst.todoapp.model.Task;
import pl.makst.todoapp.model.TaskRepository;


@Repository
interface SqlTaskRepository extends TaskRepository,JpaRepository<Task,Integer> {
    @Override
    @Query(nativeQuery = true, value = "select count(*) > 0 from tasks where id=:id")
    boolean existsById(@Param("id") Integer id);
    @Override
    boolean existsByDoneIsFalseAndGroupId(Integer groupId);
}
