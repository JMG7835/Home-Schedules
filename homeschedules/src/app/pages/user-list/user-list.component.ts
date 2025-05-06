import { Component } from '@angular/core';
import { UserComponent } from '../../components/user/user.component';

@Component({
  selector: 'app-user-list',
  imports: [UserComponent],
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.css'
})
export class UserListComponent {

}
