import { Component } from '@angular/core';
import { Routes } from '@angular/router';
import { ScheduleListComponent } from './pages/schedule-list/schedule-list.component';
import { UserListComponent } from './pages/user-list/user-list.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { UserComponent } from './pages/user/user.component';

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
  },
  {
    path: 'user',
    children:[{
      path:'',
    component: UserComponent},
    {
      path:':id',
      component: UserComponent
    }]
  },{
    path: 'schedules',
    component: ScheduleListComponent
  },{
    path: '**',
    component: NotFoundComponent
  }
];
