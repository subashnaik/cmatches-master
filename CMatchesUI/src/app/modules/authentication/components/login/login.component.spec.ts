import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { AngularmaterialModule } from "../../../material/material.module";
import { LoginComponent } from 'src/app/modules/authentication/components/login/login.component';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { RegistrationComponent } from 'src/app/modules/authentication/components/register/register.component';
import { CardContainerComponent } from 'src/app/modules/cricinfo/components/card-container/card-container.component';
import { CalendarEventComponent } from 'src/app/modules/cricinfo/components/scheduler/calendarevent.component';
import { FavourtieComponent } from 'src/app/modules/cricinfo/components/favourite/favourite.component';
import { RecommendComponent } from 'src/app/modules/cricinfo/components/recommend/recommend.component';
import { MatProgressSpinnerModule } from '@angular/material';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { AuthenticationService } from 'src/app/modules/authentication/authentication.service';

import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

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
      providers:[AuthenticationService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
