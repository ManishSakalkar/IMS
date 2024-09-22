import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManishviewComponent } from './manishview.component';

describe('ManishviewComponent', () => {
  let component: ManishviewComponent;
  let fixture: ComponentFixture<ManishviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManishviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManishviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
