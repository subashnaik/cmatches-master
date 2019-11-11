import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistrationComponent } from './modules/authentication/components/register/register.component';
import { LoginComponent } from './modules/authentication/components/login/login.component';
import { CardContainerComponent } from './modules/cricinfo/components/card-container/card-container.component';
import { AuthGuardService } from './modules/cricinfo/auth-guard.service';
import { FavourtieComponent } from './modules/cricinfo/components/favourite/favourite.component';
import { RecommendComponent } from './modules/cricinfo/components/recommend/recommend.component';
import { CalendarEventComponent } from './modules/cricinfo/components/scheduler/calendarevent.component';

const routes: Routes = [
  {
    path:"",
    component: LoginComponent    
  },
  {
    path:"login",
    component: LoginComponent    
  },
  {
    path:"register",
    component: RegistrationComponent    
  },
  {
    path:"currentmatches",
    component: CardContainerComponent,
    canActivate: [AuthGuardService],
    data: {matchType : "current"}
  },
  {
    path:"oldmatches",
    component: CardContainerComponent,
    canActivate: [AuthGuardService],
    data: {matchType : "old"}
  },
  {
    path:"upcommingmatches",
    component: CalendarEventComponent,
    canActivate: [AuthGuardService],
    data: {matchType : "upcome"}
  },
  {
    path:"favouritematches",
    canActivate: [AuthGuardService],    
    component: FavourtieComponent   
  },
  {
    path:"recommendedmatches",
    component: RecommendComponent    
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
