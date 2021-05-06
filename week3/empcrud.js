let btnGetUsers = document.querySelector('#btnGetUsers');
// let btnGetUser = document.querySelector('#btnGetUser');
// let status = document.querySelector('#status');
let results = document.querySelector('#results');

btnGetUsers.addEventListener('click', ()=>{
  let url = "http://localhost:8000/employees";
  fetch(url)
    .then(response => response.json())
    .then(response => showUsers(response));
});

// btnGetUser.addEventListener('click', ()=>{
//   let id = document.querySelector('#txtUserId').value.trim();
//   if (!id || !Number.parseInt(id)) { 
//     results.innerHTML = '<span style="color: red">Id field cannot be empty</span>';
//     return;
//   }
//   let url = "https://api.github.com/user/"+id;
//   fetch(url)
//     .then(response => response.json())
//     .then(response => showUsers([response]));
// });

function showUsers(r) {
  let data = "<table class='table table-bordered table-striped'>";
      data += "<thead class='thead-dark'> <tr>";
      data += "<th>Employee ID</th> <th>Name</th> <th>Age</th> <th>Salary</th>";
      data += "</tr> </thead>";
  r.forEach(el => {
    data += `<tr>`;
    data += `<td>${el.id}</td>`;
    data += `<td>${el.name}</td>`;
    data += `<td>${el.age}</td>`;
    data += `<td>${el.salary}</td>`;
    data += `</tr>`;
  });
  data += '</table>';
  results.innerHTML = data;
}
