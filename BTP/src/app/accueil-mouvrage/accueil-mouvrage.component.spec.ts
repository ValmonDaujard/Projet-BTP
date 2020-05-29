import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccueilMouvrageComponent } from './accueil-mouvrage.component';

describe('AccueilMouvrageComponent', () => {
  let component: AccueilMouvrageComponent;
  let fixture: ComponentFixture<AccueilMouvrageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccueilMouvrageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccueilMouvrageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
