import { TestBed } from '@angular/core/testing';

import { CricService } from './cric.service';

import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { CricMatch } from './CricMatch';

xdescribe('CricService', () => {
  let cricMatch = new CricMatch(); 
  cricMatch = { 
    matchId: "1187007",
    date: "2019-10-02T00:00:00.000Z",
    squad: true,
    team1: "India",
    team2: "South Africa",
    matchStarted: "true",
    type: "Test",
    toss: "India",
    winner: "India",
    stat: "India won by 300 runs",
    score: "Ind 500 vs SA 200",
    description: "Ind 500 vs SA 200",
    title: "Ind Vs SA",
    matchType: "Test",
    count: 0,
    favouriteType: "current"
  };

  const favouriteEndPoint = "http://localhost:8765/favouriteservice/cricinfo/cricmatch/";
  const recommendEndPoint = "http://localhost:8765/recommendationservice/cricinfo/cricmatch/get/";
  let cricService: CricService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => { 
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      providers: [CricService]
    });
    cricService = TestBed.get(CricService);
    httpTestingController = TestBed.get(HttpTestingController);

  });

  it('should be created', () => {
     expect(cricService).toBeTruthy();
  });

  it("addMatchToFavouriteList should be successful", () => {
    cricService.addMatchToFavouriteList(cricMatch).subscribe(res => {
      expect(res.body).toBe(cricMatch);
    });
    const httpMockReq = httpTestingController.expectOne(favouriteEndPoint + "save/old/naresh");
    expect(httpMockReq.request.method).toBe('POST');
    expect(httpMockReq.request.url).toEqual(favouriteEndPoint + "save/old/naresh");
  });

  it("getFavourites should be successful", () => {
    cricService.getFavourites().subscribe(res => {      
    });
    const httpMockReq = httpTestingController.expectOne(favouriteEndPoint + "get/naresh");
    expect(httpMockReq.request.method).toBe('GET');
    expect(httpMockReq.request.url).toEqual(favouriteEndPoint + "get/naresh");
  });

  it("deleteFavourite should be successful", () => {
    cricService.deleteFavourite(cricMatch).subscribe(res => {           
    });
    const httpMockReq = httpTestingController.expectOne(favouriteEndPoint + "delete/naresh/" + cricMatch.matchId);
    expect(httpMockReq.request.method).toBe('DELETE');
    expect(httpMockReq.request.url).toEqual(favouriteEndPoint + "delete/naresh/" + cricMatch.matchId);
  });

  it("getRecommendMatches should be successful", () => {
    cricService.getRecommendMatches().subscribe(res => {      
    });
    const httpMockReq = httpTestingController.expectOne(recommendEndPoint + "naresh");
    expect(httpMockReq.request.method).toBe('GET');
    expect(httpMockReq.request.url).toEqual(recommendEndPoint + "naresh");
  });

});
