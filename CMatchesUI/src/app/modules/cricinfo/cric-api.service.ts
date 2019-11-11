import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class CricAPIService {

  constructor(private httpClient: HttpClient) {

  }

  getCricMatchDetail(matchType): Observable<any> {
    if (matchType === 'current') {
      return this.httpClient.get('http://localhost:8765/favouriteservice/cricinfo/cricmatch/get/current');
    } else if (matchType === 'old') {
      return this.httpClient.get('http://localhost:8765/favouriteservice/cricinfo/cricmatch/get/old');
    }
  }

  getOldCricMatchDetail(): Observable<any> {
    return this.httpClient.get('http://localhost:8765/favouriteservice/cricinfo/cricmatch/get/old');
  }

  getEvents(): Observable<any[]> {
    return this.httpClient.get('http://localhost:8765/favouriteservice/cricinfo/cricmatch/get/events') as Observable<any>;
  }
 
}
