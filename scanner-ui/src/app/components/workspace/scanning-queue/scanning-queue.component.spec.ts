import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScanningQueueComponent } from './scanning-queue.component';

describe('ScanningQueueComponent', () => {
  let component: ScanningQueueComponent;
  let fixture: ComponentFixture<ScanningQueueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScanningQueueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScanningQueueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
