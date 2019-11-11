import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CardContainerComponent } from './components/card-container/card-container.component';
import { CardComponent } from './components/card/card.component';

import { AngularmaterialModule } from "../material/material.module";
import { HeaderComponent } from './components/header/header.component';
import { AppRoutingModule } from '../../app-routing.module';
import { FooterComponent } from './components/footer/footer.component';
import { FavourtieComponent } from './components/favourite/favourite.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { CricService } from './cric.service';
import { RecommendComponent } from './components/recommend/recommend.component';
import { MatProgressBarModule, MatProgressSpinnerModule } from '@angular/material';
import { SidebarContainerComponent } from './components/scheduler/sidebar-container.component';
import { SidebarExpandedComponent } from './components/scheduler/sidebar-expanded.component';
import { SidebarCollapsedComponent } from './components/scheduler/sidebar-collapsed.component';
import { SidebarMainComponent } from './components/scheduler/sidebar-main.component';
//import { DayPilotModule } from 'daypilot-pro-angular';
import { InterceptorService } from './interceptor.service';
import { CalendarEventComponent } from './components/scheduler/calendarevent.component';
import { FullCalendarModule } from '@fullcalendar/angular';

@NgModule({
  declarations: [CardContainerComponent,
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
  exports: [
    CardContainerComponent,
    HeaderComponent,
    AppRoutingModule,
    FavourtieComponent,
    FooterComponent,
    RecommendComponent,
    SidebarContainerComponent,
    SidebarExpandedComponent,
    SidebarCollapsedComponent,
    SidebarMainComponent,
    CalendarEventComponent,
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
export class CricMatchModule { }
