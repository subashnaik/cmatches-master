import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegistrationComponent } from './components/register/register.component';

import { AngularmaterialModule } from "../material/material.module";
import { LoginComponent } from './components/login/login.component';
import { AppRoutingModule } from '../../app-routing.module';


@NgModule({
  declarations: [RegistrationComponent, LoginComponent],
  imports: [
    CommonModule,
    AngularmaterialModule,
    AppRoutingModule
  ],
  exports: [
    AngularmaterialModule,
    AppRoutingModule
  ]
})
export class AuthenticationModule { }
