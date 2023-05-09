


const addAPI= 'http://localhost:8080/todolist/add';
const displayAPI = 'http://localhost:8080/todolist/all';
let todoController = [];


function displayTodo()
{
      //fetch data from database using the REST API endpoint from Spring Boot
      fetch(displayAPI)
          .then((resp) => resp.json())
          .then(function(data) {
              console.log("2. receive data")
              console.log(data);


              data.forEach(function (todo) {
                  const todoObj = {
                      id: todo.id,
                      title: todo.title,
                      description: todo.description,
                      date: todo.date
                 };


                  todoController.push(todoObj);
            });


           //Display all the 12 objects from the productController array
            renderTodoPage();
          })
          .catch(function(error) {
              console.log(error);
          });
}







//(3)  Display all products when user launch the product.html page
function renderTodoPage() {


   let display = "";


   for (let i = 0; i < todoController.length; i++ ) {

    const dateStr = todoController[i].date;
    const dateObj = new Date(dateStr);
    const day = String(dateObj.getDate()).padStart(2, '0');
    const month = String(dateObj.getMonth() + 1).padStart(2, '0');
    const year = dateObj.getFullYear();
    const formattedDate = `${day}/${month}/${year}`;


       display += `
           <tr>

               <td>${todoController[i].title}</td>
               <td>${todoController[i].description}</td>
               <td>${formattedDate}</td>
           </tr>
       `
   }


   document.querySelector("#row").innerHTML= display;


} //End of renderProductPage function




//4) Add new product to the product list when user clicks on the submit button from the productform.html


function addTodo(title, description, date) {
  // Form data is an object provided by the Browser API for us to send the data over to the backend
  const formData = new FormData();
  formData.append('title', title);
  formData.append('description', description);

  const [day, month, year] = date.split('/');
  const currentDate = new Date(`${year}-${month}-${day}`);

  const formattedYear = currentDate.getFullYear();
  const formattedMonth = String(currentDate.getMonth() + 1).padStart(2, '0');
  const formattedDay = String(currentDate.getDate()).padStart(2, '0');
  const formattedDate = `${formattedYear}-${formattedMonth}-${formattedDay}`;
  formData.append('date', formattedDate);

  fetch(addAPI, {
    method: 'POST',
    body: formData,
  })
    .then(function (response) {
      console.log(response.status); // Will show you the status - 200 ok, 500, 404 etc.
      if (response.ok) {
        alert('Successfully Added TODO list!');
        //displayCustomer(); // Refresh the page
      } else {
        alert('Something went wrong. Please try again');
      }
    })
    .catch((error) => {
      console.error('Error:', error);
      alert('Error adding item to TODO List. Please try again');
    });
}

