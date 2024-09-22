import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-thankyouimage',
  templateUrl: './thankyouimage.component.html',
  styleUrls: ['./thankyouimage.component.css']
})
export class ThankyouimageComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  images = ['../../assets/logout_img.png'];
}
