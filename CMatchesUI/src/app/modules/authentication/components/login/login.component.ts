import { Component, OnInit } from '@angular/core';
import { User } from '../../User';
import { AuthenticationService } from '../../authentication.service';
import { MatSnackBar } from '@angular/material';
import { Router } from '@angular/router';

export const TOKEN_NAME = "jwt_token";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User;

  constructor(
    private authService: AuthenticationService,
    private snackbar: MatSnackBar,
    private router: Router
  ) {
    this.user = new User();
  }

  login() {
    if (this.user.userId === undefined || this.user.userPassword === undefined) {
      this.snackbar.open("Invalid User ID/Password", " ", { duration: 5000 });
    } else {
      this.authService.loginUser(this.user).subscribe(data => {
        if (data) {
          localStorage.setItem(TOKEN_NAME, data.body["token"]);
          this.snackbar.open("Login Successful!!", " ", { duration: 5000 });
          this.router.navigate(["/currentmatches"]);
        }
      },
        error => {
          if (error.status === 404) {
            this.snackbar.open("Invalid User ID/password", " ", { duration: 5000 });
          }
          if (error.status === 401) {
            this.snackbar.open("User doesn't exist!!", " ", { duration: 5000 });
          }
        }
      )
    };
  }

  ngOnInit() {
  }

}
