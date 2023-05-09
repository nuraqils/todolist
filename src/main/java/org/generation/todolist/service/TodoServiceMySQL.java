package org.generation.todolist.service;


import org.generation.todolist.repository.TodoRepository;
import org.generation.todolist.repository.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TodoServiceMySQL implements TodoService {
    // ItemRepository is an interface that extends the CRUDRepository interface
    private final TodoRepository todoRepository;


    //Dependency Injection of another class object to this class object can be done with
    // @Autowired annotation
    public TodoServiceMySQL(@Autowired TodoRepository todoRepository)
    {
        this.todoRepository = todoRepository;
    }



    @Override
    public Todo save(Todo item)
    {
        // since we have done the dependency injection of the ItemRepository interface, therefore now we can any methods from the CrudRepository class
        return todoRepository.save(item);
    }


    @Override
    public void delete(int itemId)
    {
        todoRepository.deleteById(itemId);
    }


    @Override
    public ArrayList<Todo> all()
    {
        //1) @Query - Query class provided by SpringBoot : select * from item
        //2) Repository class provided by SpringBoot : we do not need to write a single query
        ArrayList<Todo> result = new ArrayList<>();
        todoRepository.findAll().forEach(result::add);
        return result;
    }


    @Override
    public Todo findById(int itemId)
    {
        // Optional is a list that accept either 0 or 1 item
        Optional<Todo> item = todoRepository.findById(itemId);
        Todo todoResponse = item.get();
        return todoResponse;
    }

}
