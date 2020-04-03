async function onSignUp() {
    var form  = document.getElementById("form");

	if (form.pswrepeat.value == form.psw.value) {
	    alert("hello");
		try{
			const response = await fetch('http://localhost:8080/sign/'
			 + form.type.value, {
		    method: 'POST',
			headers: {
			    'Accept': 'application/json',
			    'Content-Type': 'application/json'
			  },
		    body: JSON.stringify({firstName: form.fname.value, lastName: form.lname.value, email: form.email.value,
		    	password: form.psw.value, userName: form.username.value})
	  	}) 

		} catch(error) {
			alert("Signup failed, try another username");
		}
        alert("signup successful");
        window.location.href = 'http://localhost:8080/login';
		success = await response.json();
		console.log(success)
		if(success == true) {
			alert("Signup successful");
			
			window.location.href = 'http://localhost:8080/login';
			
		}


	} else {
		alert("Passwords do not match !")
	}
}

function session() {
	localStorage.clear();

}

async function onLogin(form) {

    alert(form.username.value);

	response = await fetch('http://localhost:8080/login?username=' +
	form.username.value + '&password=' + form.psw.value + '&type=' + form.type.value, {
    method: 'GET',
    credentials: 'include',
    mode: 'cors',
	headers: {
	    'Accept': 'application/json',
	    'Content-Type': 'application/json'
	  }
  	});

	try{
	    alert("hello");
		data = await response.json();
		console.log(data);
		if(data == true) {
			if (form.type.value == 'buyer') {
				window.location.href = 'http://localhost:8080/buyer';
			} else if(form.type.value == 'supplier') {
				window.location.href = 'supplier.html';
			} else {
				window.location.href = 'manager.html';
			}
			localStorage.setItem('login', true);
		} else {
			alert("Wrong credentials");

		}


	} catch(error) {
		alert("Wrong credentials");
	} 

}
