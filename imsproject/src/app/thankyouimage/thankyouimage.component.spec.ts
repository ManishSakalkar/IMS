import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThankyouimageComponent } from './thankyouimage.component';

describe('ThankyouimageComponent', () => {
  let component: ThankyouimageComponent;
  let fixture: ComponentFixture<ThankyouimageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ThankyouimageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ThankyouimageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
