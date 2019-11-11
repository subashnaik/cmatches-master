import { Component, OnInit } from '@angular/core';

import { AuthenticationService } from '../../authentication.service'
import { MatSnackBar } from '@angular/material';
import { Router } from '@angular/router';
import { User } from '../../User';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegistrationComponent implements OnInit {

  user: User;
  constructor(
    private authService: AuthenticationService,
    private snackbar: MatSnackBar,
    private router: Router) {
    this.user = new User();
  }

  register() {
    if (this.user.userId === undefined
      || this.user.userPassword === undefined
      || this.user.firstName === undefined
      || this.user.mail === undefined
    ) {
      this.snackbar.open("Please enter User ID/Password/FirstName/Email!!", " ", { duration: 5000 });
    } else {
      this.authService.registerUser(this.user).subscribe(data => {
        console.log(data);
        if (data.status === 201) {
          this.snackbar.open("Registration Successful!!", " ", {
            duration: 5000
          });
        }
        this.router.navigate(["/login"]);
      },
        error => {
          if (error.status === 409) {
            const errorMsg = error.error.message;
            this.snackbar.open("Registration UnSuccessful, User already exists!!", " ", { duration: 5000 });
          }
        }
      )
    };
  }
  ngOnInit() {
  }

}
