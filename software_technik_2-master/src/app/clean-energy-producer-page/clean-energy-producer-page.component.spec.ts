import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CleanEnergyProducerPageComponent } from './clean-energy-producer-page.component';

describe('CleanEnergyProducerPageComponent', () => {
  let component: CleanEnergyProducerPageComponent;
  let fixture: ComponentFixture<CleanEnergyProducerPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CleanEnergyProducerPageComponent]
    });
    fixture = TestBed.createComponent(CleanEnergyProducerPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
