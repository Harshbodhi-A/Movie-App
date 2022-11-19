import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterUsesrComponent } from './register-usesr.component';

describe('RegisterUsesrComponent', () => {
  let component: RegisterUsesrComponent;
  let fixture: ComponentFixture<RegisterUsesrComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterUsesrComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterUsesrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
