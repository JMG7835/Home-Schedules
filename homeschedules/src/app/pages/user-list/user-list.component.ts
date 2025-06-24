import { Component, inject, OnInit } from '@angular/core';
import { SearchBarComponent } from '../../components/search-bar/search-bar.component';
import { UserService } from '../../services/user.service';
import {User} from '../../models/user.models'
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatSortModule} from '@angular/material/sort';
import {MatButtonModule} from '@angular/material/button';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-list',
  imports: [SearchBarComponent, MatTableModule, MatPaginatorModule, MatSortModule, MatButtonModule],
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.css'
})
export class UserListComponent implements OnInit{
  dataSource = new MatTableDataSource<User>();
  displayedColumns: string[] = ['name', 'email', 'phone'];
  private userService = inject(UserService);
  private router = inject(Router);

  ngOnInit(): void {
    this.userService.getAll()
      .subscribe((res) => {
        this.dataSource = new MatTableDataSource<User>(res);
      });
  }

  createUser() {
     this.router.navigate(["/user"]);
  }

  getUsers(usersName: string): void {
    this.userService.get(usersName)
      .subscribe((res) => {
        this.dataSource = new MatTableDataSource<User>(res);  
      });
  }
}
