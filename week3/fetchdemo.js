let btnGetUsers = document.querySelector('#btnGetUsers');
let btnGetUser = document.querySelector('#btnGetUser');
let status = document.querySelector('#status');
let results = document.querySelector('#results');

btnGetUsers.addEventListener('click', ()=>{
  let url = "https://api.github.com/users";
  fetch(url)
    .then(response => response.json())
    .then(response => showUsers(response));
});

btnGetUser.addEventListener('click', ()=>{
  let id = document.querySelector('#txtUserId').value.trim();
  if (!id || !Number.parseInt(id)) { 
    results.innerHTML = '<span style="color: red">Id field cannot be empty</span>';
    return;
  }
  let url = "https://api.github.com/user/"+id;
  fetch(url)
    .then(response => response.json())
    .then(response => showUsers([response]));
});

function showUsers(r) {
  let data = "<table class='table table-bordered table-striped'>";
      data += "<thead class='thead-dark'><tr><th>ID</th><th>Login name</th><th>Avatar url</th></tr></thead>";
  r.forEach(el => {
    data += `<tr><td>${el.id}</td>`;          
    data += `<td>${el.login}</td>`;
    data += `<td><img class='rounded' src='${el.avatar_url}' alt="${el.login}'s avatar" height='100px' width='100px'/></td></tr>`;
  });
  data += '</table>';
  results.innerHTML = data;
}
