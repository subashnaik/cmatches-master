import { Component, ViewChild, OnInit, Input } from '@angular/core';
import { FullCalendarComponent } from '@fullcalendar/angular';
import dayGridPlugin from '@fullcalendar/daygrid';
import timeGrigPlugin from '@fullcalendar/timegrid';
import interactionPlugin from '@fullcalendar/interaction'; 
import { HttpClient } from '@angular/common/http';
import { CricAPIService } from '../../cric-api.service';

@Component({
  selector: 'app-root',
  templateUrl: './calendarevent.component.html',
  styleUrls: ['./calendarevent.component.css']
})
export class CalendarEventComponent implements OnInit {

  @ViewChild('calendar') calendarComponent: FullCalendarComponent; 

  calendarVisible = true;
  calendarPlugins = [dayGridPlugin, timeGrigPlugin, interactionPlugin];
  calendarWeekends = true;
  calendarEvents = [];
  
  constructor(private httpClient: HttpClient, private cricapiService: CricAPIService) {
   
  }

  ngOnInit() {
    this.cricapiService.getEvents().subscribe(result => {
      console.log(result);
      this.calendarEvents = this.calendarEvents.concat(
        result['data']
      );
    });
  }

  toggleVisible() {
    this.calendarVisible = !this.calendarVisible;
  }

  toggleWeekends() {
    this.calendarWeekends = !this.calendarWeekends;
  }

  gotoPast() {
    let calendarApi = this.calendarComponent.getApi();
    calendarApi.gotoDate('2000-01-01'); 
  }

  handleDateClick(arg) {
    if (confirm('Would you like to add an event to ' + arg.dateStr + ' ?')) {
      this.calendarEvents = this.calendarEvents.concat({
        title: 'New Event',
        start: arg.date,
        allDay: arg.allDay
      })
    }
  }

}
