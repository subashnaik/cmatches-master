import { Component, OnInit } from '@angular/core';
import { CricService } from '../../cric.service';
import { CricMatch } from '../../CricMatch';
import { ActivatedRoute } from '@angular/router';
import { MatSnackBar } from '@angular//material';

import { CricAPIService } from '../../cric-api.service';

@Component({
  selector: 'app-card-container',
  templateUrl: './card-container.component.html',
  styleUrls: ['./card-container.component.css']
})
export class CardContainerComponent implements OnInit {

  cricMatches: Array<CricMatch>;
  cricMatch: CricMatch;
  id: number;
  matchType: string;
  errorCode: number;
  searchCricMatches: Array<CricMatch>;
  searchKey: string;
  data: any;
  recAddStatusCode: number;
  result = [];
  loading = true;
  constructor(private cricService: CricService,
    private cricAPI: CricAPIService,
    private routes: ActivatedRoute,
    private matSnackbar: MatSnackBar) {
    this.cricMatches = [];
  }

  ngOnInit() {
      this.routes.data.subscribe(data => {
      this.matchType = data.matchType;
    });
    this.cricAPI.getCricMatchDetail(this.matchType).subscribe(match => {
      this.data = match['matches'];
      if (this.data === undefined) {
        this.data = match['data'];
      }
      this.data.forEach(element => {
        this.cricMatch = new CricMatch();
        this.cricMatch.matchId = element["unique_id"];
        this.cricMatch.date = element["date"];
        this.cricMatch.matchStarted = element["matchStarted"];
        this.cricMatch.squad = element["squad"];
        this.cricMatch.team1 = element["team-1"];
        this.cricMatch.team2 = element["team-2"];
        this.cricMatch.toss = element["toss_winner_team"];
        this.cricMatch.type = element["type"];
        this.cricMatch.winner = element["winner_team"];
        this.cricMatch.stat = element["stat"];
        this.cricMatch.score = element["score"];
        this.cricMatch.description = element["description"];
        this.cricMatch.title = element["title"];
        this.cricMatch.matchType = this.matchType;
        this.cricMatch.count = element["count"];
        this.cricMatch.favouriteType = element["favouriteType"];
        this.cricMatches.push(this.cricMatch);
        this.searchCricMatches = this.cricMatches;
      })
      this.loading = false;
    },
      error => {
        this.errorCode = parseInt(`${error.status}`, 10);
        if (this.errorCode === 404) {
          this.matSnackbar.open("The service is temporarily down, please try after some time", " ", {
            duration: 5000
          });
        }
      }

    );
  }

  addToFavouriteList(cricMatch) {
    this.cricService.addMatchToFavouriteList(cricMatch).subscribe(
      data => {
        this.errorCode = data.status;
        if (this.errorCode === 201) {
          this.matSnackbar.open("Favourite Cricket Match has been added Successfully !!!", " ", {
            duration: 5000
          });

        }
      },
      error => {
        const errorMsg = `${error.error.message}`;
        this.errorCode = parseInt(`${error.status}`, 10);
        if (this.errorCode === 409) {
          this.matSnackbar.open("Favourite Cricket Match has already exists !!!", " ", {
            duration: 5000
          });
        }
      }
    )
  }

  onKey(event: any) {
    this.searchKey = event.target.value;
    this.result = this.searchCricMatches.filter(match => {
      console.log(match);
      return match.team1.match(this.searchKey) || match.team2.match(this.searchKey) || match.description.match(this.searchKey);
    });
    this.cricMatches = this.result;
  }

}
