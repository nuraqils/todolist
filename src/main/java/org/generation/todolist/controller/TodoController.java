package org.generation.todolist.controller;

import org.generation.todolist.controller.dto.TodoDTO;
import org.generation.todolist.repository.entity.Todo;
import org.generation.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/todolist")
public class TodoController {
    private final TodoService todoService;

    // Dependency Injection of the ItemService object so that the controller can call any methods in the ItemServiceMySQL class
    public TodoController( @Autowired TodoService todoService )
    {
        this.todoService = todoService;
    }

    // 1) API endpoint to get all items to display on the frontend
    // Front-end will issue a GET http request to this endpoint

    // without CrossOrigin, the frontend will not be able to call this endpoint as it is not a valid domain (eg. tp.edu.sg, generation.org)
    // localhost is not a valid domain
    @CrossOrigin
    @GetMapping( "/all" ) // call this API endpoint to execute the getCustomers() method API that we have created
    public Iterable<Todo> getCustomers() // iterable is a collection of items to return to the frontend
    {
        return todoService.all();
    }

    @CrossOrigin
    @GetMapping( "/{id}" )
    public Todo findCustomerById( @PathVariable Integer id )
    {
        return todoService.findById( id );
    }


    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        todoService.delete( id );
    }

    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="title", required = true) String title,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="date", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date)
    {
        System.out.println("Hello World");

        TodoDTO todoDto = new TodoDTO(title, description, date);
                todoService.save(new Todo(todoDto));
    }

}
