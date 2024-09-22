import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManishallComponent } from './manishall.component';

describe('ManishallComponent', () => {
  let component: ManishallComponent;
  let fixture: ComponentFixture<ManishallComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManishallComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManishallComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
