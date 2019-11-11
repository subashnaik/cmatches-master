import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FavourtieComponent } from './favourite.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { MatProgressSpinnerModule } from '@angular/material';

import { AngularmaterialModule } from 'src/app/modules/material/material.module';
import { CommonModule } from '@angular/common';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { RecommendComponent } from 'src/app/modules/cricinfo/components/recommend/recommend.component';
import { CalendarEventComponent } from 'src/app/modules/cricinfo/components/scheduler/calendarevent.component';
import { CardContainerComponent } from 'src/app/modules/cricinfo/components/card-container/card-container.component';
import { RegistrationComponent } from 'src/app/modules/authentication/components/register/register.component';
import { LoginComponent } from 'src/app/modules/authentication/components/login/login.component';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { CricService } from 'src/app/modules/cricinfo/cric.service';

describe('FavourtieComponent', () => {
  let component: FavourtieComponent;
  let fixture: ComponentFixture<FavourtieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginComponent, 
        RegistrationComponent, 
        CardContainerComponent, 
        CalendarEventComponent, 
        FavourtieComponent,
        RecommendComponent
      ],
        schemas: [NO_ERRORS_SCHEMA],
      imports: [
        CommonModule,
        AngularmaterialModule,
        AppRoutingModule,
        MatProgressSpinnerModule,
        HttpClientModule,
        BrowserAnimationsModule
      ],
      providers: [CricService]

    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FavourtieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
