import { TestBed } from '@angular/core/testing';

import { AuthenticationService } from './authentication.service';

import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

const testdata = {
  username: "naresh",
  password: "pass",
  email: "naresh@gmail.com"
};

describe('AuthenticationService', () => {
  let authService: AuthenticationService;
  let httpTestingController: HttpTestingController;
  const testForRegistration = 'http://localhost:8765/favouriteservice/cricinfo/user/register';
  const testForLogin = 'http://localhost:8765/userservice/cricinfo/user/login';
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [AuthenticationService]

    });

    authService = TestBed.get(AuthenticationService);
    httpTestingController = TestBed.get(HttpTestingController);
  });

  it('should be created', () => {
    expect(authService).toBeTruthy();
  });

  it("registerUser() should be successful", () => {
    authService.registerUser(testdata).subscribe(res => {
      expect(res.body).toBe(testdata);
    });
    const httpMockReq = httpTestingController.expectOne(testForRegistration);
    expect(httpMockReq.request.method).toBe('POST');
    expect(httpMockReq.request.url).toEqual(testForRegistration);
  });

  it("login() should be successful", () => {
    authService.loginUser(testdata).subscribe(res => {
      expect(res.body).toBe(testdata);
    });
    const httpMockReq = httpTestingController.expectOne(testForLogin);
    expect(httpMockReq.request.method).toBe('POST');
    expect(httpMockReq.request.url).toEqual(testForLogin);
  });

});
