import { Routes } from '@angular/router';
import { ScheduleListComponent } from './pages/schedule-list/schedule-list.component';
import { UserListComponent } from './pages/user-list/user-list.component';

export const routes: Routes = [
  { path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: UserListComponent
  },
  {
    path: 'users',
    component: UserListComponent
  },{
    path: 'schedules',
    component: ScheduleListComponent

  }
];
