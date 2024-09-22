import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContactallComponent } from './contactall.component';

describe('ContactallComponent', () => {
  let component: ContactallComponent;
  let fixture: ComponentFixture<ContactallComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContactallComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContactallComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
