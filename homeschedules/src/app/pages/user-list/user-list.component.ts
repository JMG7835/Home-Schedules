import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { SearchBarComponent } from '../../components/search-bar/search-bar.component';
import { UserService } from '../../services/user.service';
import {User} from '../../models/user.models'
import {MatPaginator, PageEvent, MatPaginatorModule} from '@angular/material/paginator';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';

@Component({
  selector: 'app-user-list',
  imports: [SearchBarComponent, MatTableModule, MatPaginatorModule],
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.css'
})
export class UserListComponent implements OnInit {
  users: [];
  displayedColumns: string[] = ['name', 'email', 'phone'];
  totalUsers = 0;
  pageSize = 10;
  pageIndex = 0;
  @ViewChild(UserListComponent) paginator: MatPaginator;

  constructor(private userService: UserService) {
    this.users = [];
  }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(): void {
    this.userService.getUsers(this.pageIndex + 1, this.pageSize)
      .subscribe((response) => {
        this.users = response.data;
        this.totalUsers = response.total;
      });
  }

  onPageChange(event: PageEvent): void {
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.getUsers();
  }
}
