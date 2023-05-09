package org.generation.todolist.repository.entity;


//Repository package is part of the Model Component (MVC)
//Item is the entity class to use to map against the table from the database
// model is the object used to map to the database table & fields
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.generation.todolist.controller.dto.TodoDTO;

import java.util.Date;

@Entity
public class Todo {

    //Properties/attributes - will be mapped to the columns of the database table
    //Need to use the Wrapper class on primitive data types - need to pass the datatype
    // as an object to CRUDRepository Class (provided by SpringBoot framework)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is to auto increment the ID
    private Integer id;

    //retrieve product item by ID - has to be an object
    private String title;
    private String description;
    private Date date;

    //Item Class is used to map against the database table
    //Any CRUD operations, JPA will make use of this Item Class
    // For Read or Delete operation, the JPA requires an empty constructor to populate all the records from the database table as the Item instance

    // constructor overloading
    public Todo() {}

    // DTO stands for Data Transfer Object is a setup in the Controller layer
    // Create and Update operation, JPA requires the ItemDTO object to be sent via the controller
    public Todo(TodoDTO todoDTO)
    {
        //Transfer the object (with the data) to Entity Class for mapping with the
        // database table columns and to be able to save the data in the columns
        this.title = todoDTO.getTitle();
        this.description = todoDTO.getDescription();
        this.date = todoDTO.getDate();

    }

    public Integer getId()
    {
        return id;
    }


    public void setId( Integer id )
    {
        this.id = id;
    }


    public String getTitle()
    {
        return title;
    }


    public void setTitle( String title )
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }


    public void setDescription( String description )
    {
        this.description = description;
    }


    public Date getDate()
    {
        return date;
    }


    public void setDate( Date date )
    {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "Item{" + "id=" + id + ", title='" + title + '\'' + ", description='" +
                description+ ", date='" + date + '}';
    }

}
