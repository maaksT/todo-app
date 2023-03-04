package pl.makst.todoapp.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.makst.todoapp.model.Task;
import pl.makst.todoapp.model.TaskGroupRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
class TempService {
    @Autowired
    List<String> temp(TaskGroupRepository repository){
        return repository.findAll().stream()
                .flatMap(taskGroup -> taskGroup.getTasks().stream())
                        .map(Task::getDescription)
                        .collect(Collectors.toList());
    }
}
