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
import { HttpClientModule } from '@angular/common/http';
import { CricAPIService } from 'src/app/modules/cricinfo/cric-api.service';

xdescribe('CardContainerComponent', () => {
  let component: CardContainerComponent;
  let fixture: ComponentFixture<CardContainerComponent>;
  let cricAPI: CricAPIService;

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
        HttpClientModule,
        MatProgressSpinnerModule,
        FullCalendarModule
      ],
      providers: [
        CricService,
        CricAPIService,
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
    fixture = TestBed.createComponent(CardContainerComponent);
    component = fixture.componentInstance;
    cricAPI = fixture.debugElement.injector.get(CricAPIService);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
