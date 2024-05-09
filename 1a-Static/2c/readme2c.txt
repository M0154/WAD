https://www.digitalocean.com/community/tutorials/getting-started-with-angular-using-the-angular-cli

powershell - if ng not recognized as internal command  Set-ExecutionPolicy -Scope CurrentUser -ExecutionPolicy Unrestricted
npm uninstall -g @angular/cli cache clean
npm install -g @angular/cli@latest
if any    npm fund 
if any    npm install -g @angular/cli@ update       
ng new student                            

ng version
ng serve

ng g c register  

ng: This is the Angular CLI command.
g: This is short for "generate." The g command is used to generate different parts of an Angular application, such as components, services, modules, etc.
c: This stands for "component." In Angular, components are the building blocks of the user interface. They encapsulate the template, data, and behavior of a part of the UI. The c flag indicates that you want to generate a new component.
So, when you run ng g c register, you are instructing the Angular CLI to generate a new component named "register." This command will create several files associated with the "register" component, including a TypeScript file (.ts), an HTML template file (.html), a CSS file (.css), and a spec file for testing (.spec.ts). Additionally, it will update the necessary module file to declare the new component so that it can be used in your Angular application.


input{
    width: 400px;
    height: 25px;
    margin: 100px;
    padding: 5px;
}


import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Register Form';

  displayname='';
  displayaddress='';
  displaycontact='';
  displayemail='';

  getvalue(name:string, address:string, contact:string, email:string){
    this.displayname=name;
    this.displayaddress=address;
    this.displaycontact=contact;
    this.displayemail=email;
  }
}



 <h1>{{title}}</h1>

 <input type="text" #name placeholder="Enter your name" name="Name"> <br>

 <input type="text" #address placeholder="Enter your address" name="Address"> <br>

 <input type="text" #contact placeholder="Enter your number" name="Contact"> <br>

 <input type="email" #email placeholder="Enter your email" name="Email"> <br>

 <input type="password" #name placeholder="Enter your password" name="password"> <br>

 <button (click)="getValue(name.value, address.value, contact.value, email.value)">Register </button>

 <h1>Your Register Data </h1> <br>

 <p> Name:{{displayname}}</p>
 <p> Address:{{displayaddress}}</p>
 <p>Contact:{{dispalycontact}}</p>
 <p> Email:{{displayemail}}</p>