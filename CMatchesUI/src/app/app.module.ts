import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { CricMatchModule } from './modules/cricinfo/cricmatch.module';
import { AuthenticationModule } from './modules/authentication/authentication.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AuthenticationService } from './modules/authentication/authentication.service';
import { AuthGuardService } from './modules/cricinfo/auth-guard.service';
import { CricAPIService } from './modules/cricinfo/cric-api.service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CricMatchModule,
    AuthenticationModule,
    BrowserAnimationsModule
  ],
  providers: [
    AuthenticationService,
    AuthGuardService,
    CricAPIService],
  bootstrap: [AppComponent]
})
export class AppModule { }
