import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccueilMoeuvreComponent } from './accueil-moeuvre.component';

describe('AccueilMoeuvreComponent', () => {
  let component: AccueilMoeuvreComponent;
  let fixture: ComponentFixture<AccueilMoeuvreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccueilMoeuvreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccueilMoeuvreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
