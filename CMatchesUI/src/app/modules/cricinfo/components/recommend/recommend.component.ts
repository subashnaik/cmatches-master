import { Component, OnInit } from '@angular/core';
import { CricService } from '../../cric.service';
import { CricMatch } from '../../CricMatch';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-recommend',
  templateUrl: './recommend.component.html',
  styleUrls: ['./recommend.component.css']
})
export class RecommendComponent implements OnInit {

  cricMatches: Array<CricMatch>;
  recData = true;
  loading = true;
  errorCode: number;
  constructor(private cricService: CricService, private snackbar: MatSnackBar) { }

  ngOnInit() {
    this.cricService.getRecommendMatches().subscribe(data => {
      this.cricMatches = data;
      if (data.length === 0) {
        this.snackbar.open("Recommended matches not found", " ", {
          duration: 5000
        });
      }
      this.loading = false;
    },
      error => {
        this.errorCode = parseInt(`${error.status}`, 10);
        if (this.errorCode === 404 || this.errorCode === 500) {
          this.snackbar.open("Recommended matches not found", " ", {
            duration: 5000
          });
        }
      }
    );
  }

}
