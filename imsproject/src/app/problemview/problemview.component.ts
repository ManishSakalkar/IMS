import { Component, OnInit } from '@angular/core';
import { Problem } from '../problem';
import { ProblemService } from '../problem.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-problemview',
  templateUrl: './problemview.component.html',
  styleUrls: ['./problemview.component.css']
})
export class ProblemviewComponent implements OnInit {

  // send this data to UI
  problems: Problem[] = [];
  message: string ='';
  // inject service layer
  constructor(private service: ProblemService, private router: Router) { }

  // on page load call this method
  ngOnInit(): void {
    this.getAllProblems();
  }
  // fetch data from backend application using service
  // tslint:disable-next-line: typedef
  getAllProblems() {
    return this.service.getAllProblems()
    .subscribe(
      data => {
        this.problems = data;
      }, error => {
        console.log(error);
      }
    );
  }

  

 
  images = ['../../assets/men.jpg'];
}



