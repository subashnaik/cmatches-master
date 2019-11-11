import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { CricMatch } from '../../CricMatch';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  @Input()
  cricMatch: CricMatch;

  @Output()
  addToFavouriteList = new EventEmitter();

  @Output()
  deleteFromFavouriteList = new EventEmitter();

  ngOnInit() {

  }

  addButtonClick(cricMatch) {
    this.addToFavouriteList.emit(cricMatch);
  }

  deletebutton(cricMatch) {
    this.deleteFromFavouriteList.emit(cricMatch);
  }
}
