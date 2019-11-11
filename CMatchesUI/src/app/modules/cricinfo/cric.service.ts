import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { USER_NAME } from '../authentication/authentication.service';
import { CricMatch } from './CricMatch';

@Injectable()
export class CricService {

  thirdpartyApi: string;
  apikey: string;
  searchWith: string;
  otherDetail: string;
  username: string;
  springEndPoint: string;
  recommendEndPoing: string;


  constructor(private httpClient: HttpClient) {     
   
  }
  
  getRecommendMatches(): Observable<CricMatch[]> {
    const url = 'http://localhost:8765/recommendationservice/cricinfo/cricmatch/get'; 
    return this.httpClient.get<CricMatch[]>(url);
  }

  getFavourites(): Observable<CricMatch[]> {

    this.username = sessionStorage.getItem(USER_NAME);
    const url = `http://localhost:8765/favouriteservice/cricinfo/cricmatch/get/`+ this.username;   
    return this.httpClient.get<CricMatch[]>(url);
  }

  addMatchToFavouriteList(cricMatch: CricMatch){
    this.username = sessionStorage.getItem(USER_NAME);
    const url = `http://localhost:8765/favouriteservice/cricinfo/cricmatch/save/`+ cricMatch.matchType + "/" + this.username;
    return this.httpClient.post(url, cricMatch, {
      observe: "response"
    });
  }

  deleteFavourite(cricMatch: CricMatch) {
    this.username = sessionStorage.getItem(USER_NAME);
    const url = `http://localhost:8765/favouriteservice/cricinfo/cricmatch/delete/`+ this.username + "/" + cricMatch.matchId;
    return this.httpClient.delete(url);
  }

}
