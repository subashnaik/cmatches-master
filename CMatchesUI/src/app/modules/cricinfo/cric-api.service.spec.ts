import { TestBed } from '@angular/core/testing';

import { CricAPIService } from './cric-api.service';
import { HttpTestingController } from '@angular/common/http/testing/src/api';
import { HttpClientTestingModule } from '@angular/common/http/testing';


describe('CricAPIService', () => {
  let cricAPIServie : CricAPIService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
    imports: [HttpClientTestingModule
    ],
    providers:[CricAPIService]
  });
  cricAPIServie = TestBed.get(CricAPIService);
  httpMock = TestBed.get(HttpClientTestingModule);
  });

  it('should be created', () => {
    const service: CricAPIService = TestBed.get(CricAPIService);
    expect(service).toBeTruthy();
  });
});
