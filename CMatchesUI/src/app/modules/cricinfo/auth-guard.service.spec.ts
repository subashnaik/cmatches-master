import { async, TestBed } from '@angular/core/testing';

import { AuthGuardService } from './auth-guard.service';

xdescribe('AuthGuardService', () => {
  let authService : AuthGuardService;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
    
    providers:[AuthGuardService]
  });
}));
  authService = TestBed.get(AuthGuardService);


  it('should be created', () => {
    const service: AuthGuardService = TestBed.get(AuthGuardService);
    expect(service).toBeTruthy();
  });
});
