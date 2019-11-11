import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AngularmaterialModule } from "../../../material/material.module";

import { MatProgressBarModule, MatProgressSpinnerModule } from '@angular/material';

import { FullCalendarModule } from '@fullcalendar/angular';
import { NO_ERRORS_SCHEMA } from '@angular/core/';
import { CardComponent } from 'src/app/modules/cricinfo/components/card/card.component';
import { HeaderComponent } from 'src/app/modules/cricinfo/components/header/header.component';

import { FooterComponent } from 'src/app/modules/cricinfo/components/footer/footer.component';
import { FavourtieComponent } from 'src/app/modules/cricinfo/components/favourite/favourite.component';
import { RecommendComponent } from 'src/app/modules/cricinfo/components/recommend/recommend.component';
import { SidebarContainerComponent } from 'src/app/modules/cricinfo/components/scheduler/sidebar-container.component';
import { SidebarExpandedComponent } from 'src/app/modules/cricinfo/components/scheduler/sidebar-expanded.component';
import { SidebarCollapsedComponent } from 'src/app/modules/cricinfo/components/scheduler/sidebar-collapsed.component';
import { SidebarMainComponent } from 'src/app/modules/cricinfo/components/scheduler/sidebar-main.component';
import { CalendarEventComponent } from 'src/app/modules/cricinfo/components/scheduler/calendarevent.component';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { CricService } from 'src/app/modules/cricinfo/cric.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { InterceptorService } from 'src/app/modules/cricinfo/interceptor.service';
import { CardContainerComponent } from 'src/app/modules/cricinfo/components/card-container/card-container.component';
import { LoginComponent } from 'src/app/modules/authentication/components/login/login.component';
import { RegistrationComponent } from 'src/app/modules/authentication/components/register/register.component';

const cricMatch = {
  matchId: '123',
  date: '10/11/2019',
  squad: true,
  team1: 'India',
  team2: 'Bangladest',
  matchStarted: 'true',
  type: 'T20',
  toss: 'India',
  winner: 'India',
  stat: 'India won',
  score: 'India 200/8, Bangladesh 199/9',
  description: 'T20',
  title: 'T20 match',
  matchType: 'T20',
  count: 0,
  favouriteType: 'Old'
}

describe('CardComponent', () => {
  let component: CardComponent;
  let fixture: ComponentFixture<CardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CardContainerComponent,
        RegistrationComponent, 
        CardContainerComponent, 
        CalendarEventComponent, 
        FavourtieComponent,
        RecommendComponent,
        LoginComponent,
        CardComponent,
        HeaderComponent,
        FooterComponent,
        FavourtieComponent,
        RecommendComponent,
        SidebarContainerComponent,
        SidebarExpandedComponent,
        SidebarCollapsedComponent,
        SidebarMainComponent,
        CalendarEventComponent
      ],
      schemas: [NO_ERRORS_SCHEMA],
      imports: [
        CommonModule,
        AngularmaterialModule,
        BrowserAnimationsModule,
        AppRoutingModule,
        MatProgressBarModule,
        //DayPilotModule,
        MatProgressSpinnerModule,
        FullCalendarModule
      ],
      providers: [
        CricService,
        {
          provide: HTTP_INTERCEPTORS,
          useClass: InterceptorService,
          multi: true
        },
        DatePipe
      ],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CardComponent);
    component = fixture.componentInstance;
    component.cricMatch = cricMatch
    fixture.detectChanges();
  });
 
  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
