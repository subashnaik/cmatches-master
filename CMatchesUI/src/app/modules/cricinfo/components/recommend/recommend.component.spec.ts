import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecommendComponent } from './recommend.component';


import { LoginComponent } from 'src/app/modules/authentication/components/login/login.component';
import { RegistrationComponent } from 'src/app/modules/authentication/components/register/register.component';
import { CardContainerComponent } from 'src/app/modules/cricinfo/components/card-container/card-container.component';
import { CalendarEventComponent } from 'src/app/modules/cricinfo/components/scheduler/calendarevent.component';
import { FavourtieComponent } from 'src/app/modules/cricinfo/components/favourite/favourite.component';

import { NO_ERRORS_SCHEMA } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { MatProgressSpinnerModule } from '@angular/material';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { AngularmaterialModule } from 'src/app/modules/material/material.module';
import { CommonModule } from '@angular/common';
import { CricService } from 'src/app/modules/cricinfo/cric.service';

describe('RecommendComponent', () => {
  let component: RecommendComponent;
  let fixture: ComponentFixture<RecommendComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginComponent, 
        RegistrationComponent, 
        CardContainerComponent, 
        CalendarEventComponent, 
        FavourtieComponent,
        RecommendComponent,
        
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
    fixture = TestBed.createComponent(RecommendComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
