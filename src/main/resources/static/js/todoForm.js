



//When user clicks on 'Save Item'

//2) validate the input values

// Add an onsubmit event listener to the new item form
addTodoForm.addEventListener('submit', (event) => {


   // Prevent default action of the form submission
   event.preventDefault();
   // //1) store all the input values in variables
   const title = document.querySelector('#title').value;
   const description = document.querySelector('#description').value;
   const date = document.querySelector('#date').value;





   /*
       2) Do the Validation code here
   */


//3) calls a function from the productController.js to access the API to add the new item to the database

   addTodo(title, description, date); //arguments


});



