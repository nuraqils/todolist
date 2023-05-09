package org.generation.todolist.service;


import org.generation.todolist.repository.entity.Todo;

import java.util.ArrayList;

public interface TodoService {

    //save method is for 2 purposes - Create new item & Update existing item
    Todo save(Todo todo);


    //Delete item from database - based on item Id
    void delete(int Id);


    //Read all item from database
    ArrayList<Todo> all();


    //Read an item from database - based on item Id
    Todo findById(int Id);
}
