import { Component } from '@angular/core';
import { SearchBarComponent } from '../../components/search-bar/search-bar.component';
import { UserService } from '../../services/user.service';
import {User} from '../../models/user.models'
import {PageEvent, MatPaginatorModule} from '@angular/material/paginator';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatSortModule} from '@angular/material/sort';

@Component({
  selector: 'app-user-list',
  imports: [SearchBarComponent, MatTableModule, MatPaginatorModule, MatSortModule],
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.css'
})
export class UserListComponent {
  dataSource = new MatTableDataSource<User>();
  displayedColumns: string[] = ['name', 'email', 'phone'];

  constructor(private userService: UserService) {  
    this.userService.getAll()
      .subscribe((res) => {
        this.dataSource = new MatTableDataSource<User>(res);
      });
  }

  getUsers(usersName: string): void {
    this.userService.get(usersName)
      .subscribe((res) => {
        this.dataSource = new MatTableDataSource<User>(res);  
      });
  }
}
