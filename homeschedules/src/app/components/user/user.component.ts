import {ChangeDetectionStrategy, Component} from '@angular/core';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatCardModule} from '@angular/material/card';
import {MatChipsModule} from '@angular/material/chips';

@Component({
  selector: 'app-user',
  imports: [MatCardModule, MatChipsModule, MatProgressBarModule],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class UserComponent {
   name: string = "toto" ;
   email: string = "toto" ;
   phone: string = "toto";
   address: string = "toto";
   city: string = "toto" ;
   zip: string = "toto";
}
