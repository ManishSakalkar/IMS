import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loginadmin',
  templateUrl: './loginadmin.component.html',
  styleUrls: ['./loginadmin.component.css']
})
export class LoginadminComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  profileForm = new FormGroup({
    name: new FormControl(null, [Validators.required]),
    name1: new FormControl(null, [Validators.required,Validators.minLength(6)]),
  });
  onSubmit(){
    const val=this.profileForm.value;
    const inventory = [
       {name: 'manish'},
       {name: 'reddy'},
       {name: 'pavani'},
       {name: 'aishwarya'},
       {name: 'keerthi'},
       {name: 'anup'},
       {name: 'pradeep'},
       {name: 'pavan'},
       {name: 'shrinivaasan'},
       {name: 'sahana'},
       {name: 'lokesh'},
       {name: 'pradeepchinchole'},
       {name: 'sridatta'},
       {name: 'gowtham'},
       {name: 'jhansi'}
       
   ]; 
   
   function findCherries(fruit: { name: string; }) { 
       return fruit.name === val.name;
   }
   
   const nill=inventory.find(findCherries);
   console.log(nill);
   if ( typeof nill=== 'undefined') {
   
     alert("invalid login credentials");
     }
     else  {
       this.router.navigate(['admin']);
     }
  }
  }
