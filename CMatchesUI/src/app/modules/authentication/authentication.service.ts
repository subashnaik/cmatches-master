import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export const USER_NAME = "userId";
export const TOKEN_NAME = "jwt_token";

@Injectable()
export class AuthenticationService {
  private registrationUrl: string;
  private loginUrl: string;

  constructor(private httpclient: HttpClient) {
    this.loginUrl = 'http://localhost:8765/userservice/cricinfo/user/login';
    this.registrationUrl = 'http://localhost:8765/favouriteservice/cricinfo/user/register';
  }

  registerUser(user) {
    return this.httpclient.post(this.registrationUrl, user, { observe: "response" });
  }

  loginUser(user) {
    sessionStorage.setItem(USER_NAME, user.userId);
    return this.httpclient.post(this.loginUrl, user, { observe: "response" });
  }

  getToken() {
    return localStorage.getItem(TOKEN_NAME);
  }

  isTokenExpired(token?: string): boolean {
    if (localStorage.getItem(TOKEN_NAME)) {
      return true;
    } else {
      return false;
    }
  }

  logout() {
    sessionStorage.removeItem(USER_NAME);
    sessionStorage.clear();
    localStorage.removeItem(TOKEN_NAME);
    sessionStorage.clear();
  }
}
