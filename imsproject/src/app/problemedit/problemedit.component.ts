import { Component, OnInit } from '@angular/core';
import { Problem } from '../problem';
import { ProblemService } from '../problem.service';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-problemedit',
  templateUrl: './problemedit.component.html',
  styleUrls: ['./problemedit.component.css']
})
export class ProblemeditComponent implements OnInit {
// declare variables
  // declare variables
  id!: number;
  problem!: Problem;

  // inject service and acivated Route param
  constructor(private service: ProblemService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    // read id sent by all component as /edit/id
    // tslint:disable-next-line: no-string-literal
    this.id = this.activatedRoute.snapshot.params['id'];
    // make service call to get employee object
    this.service.getOneProblem(this.id).subscribe(
      data => {
      this.problem = data;
      console.log(this.problem);
    }, error => {
      console.log(error);
    });
  }

  // tslint:disable-next-line: typedef
  updateProblem() {
    this.service.updateProblem(this.id, this.problem)
    .subscribe( data => {
      console.log(data);
      this.router.navigate(['all5']);
    });
  }

  images = ['../../assets/admin.png']
}


