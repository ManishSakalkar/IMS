import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customerhomepage',
  templateUrl: './customerhomepage.component.html',
  styleUrls: ['./customerhomepage.component.css']
})
export class CustomerhomepageComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  images = ['../../assets/9.jpg','../../assets/Car_1.jpg','../../assets/Car_2.jpg'];

}
