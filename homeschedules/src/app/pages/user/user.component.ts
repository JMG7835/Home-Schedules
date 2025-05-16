import {ChangeDetectionStrategy, Component, input, InputSignal} from '@angular/core';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatCardModule} from '@angular/material/card';
import {MatChipsModule} from '@angular/material/chips';
import {User} from '../../models/user.models'

@Component({
  selector: 'app-user',
  imports: [MatCardModule, MatChipsModule, MatProgressBarModule],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class UserComponent {
   user : InputSignal<User> = input(new User());
}
