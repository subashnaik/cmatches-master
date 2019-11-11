import { Component, OnInit } from '@angular/core';
import { CricService } from '../../cric.service';
import { CricMatch } from '../../CricMatch';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-favourite-list',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.css']
})
export class FavourtieComponent implements OnInit {
  matches: Array<CricMatch>;
  errorCode: number;
  loading = true;
  favouriteData = true;
  constructor(
    private cricService: CricService,
    private snackbar: MatSnackBar) { }

  ngOnInit() {
    this.cricService.getFavourites().subscribe(data => {
      this.matches = data;
      if (data.length === 0) {
        this.snackbar.open("Favourites not found", " ", {
          duration: 5000
        });
      }
      this.loading = false;
    },
      error => {
        this.errorCode = parseInt(`${error.status}`, 10);
        if (this.errorCode === 404 || this.errorCode === 500) {
          this.snackbar.open("Favourite Matches was not found!!", " ", {
            duration: 5000
          });
        }
      }
    );

  }

  deleteFromFavouriteList(cricmatch) {
    this.cricService.deleteFavourite(cricmatch).subscribe(data => {
      const index = this.matches.indexOf(cricmatch);
      this.matches.splice(index, 1);
      this.snackbar.open("Successfully Deleted", " ", {
        duration: 5000
      });
    },
      error => {
        this.errorCode = parseInt(`${error.status}`, 10);
        if (this.errorCode === 404) {
          this.snackbar.open("Favourite Match was not found!!", " ", {
            duration: 5000
          });
        }
      });
    return this.matches;
  }

}
