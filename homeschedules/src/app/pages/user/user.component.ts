import {ChangeDetectionStrategy, Component, inject, signal, OnInit} from '@angular/core';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatCardModule} from '@angular/material/card';
import {MatChipsModule} from '@angular/material/chips';
import {ActivatedRoute} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {UserService} from '../../services/user.service';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-user',
  imports: [MatCardModule, MatChipsModule, MatProgressBarModule, MatFormFieldModule,MatInputModule,ReactiveFormsModule],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class UserComponent implements OnInit{
  formGroup = new FormGroup({
      name: new FormControl('',[Validators.required]),
      email: new FormControl('',[Validators.required]),
      phone: new FormControl('',[Validators.required]),
      address: new FormControl(''),
      city: new FormControl(''),
      zip: new FormControl(''),
    });
  private route = inject(ActivatedRoute);
  userId = signal<number | undefined>(undefined);
  name = new FormControl('');
  private userService = inject(UserService);

  ngOnInit(): void {
  
    const params = this.route.snapshot.params;
    this.userId.set(params['id'] ? parseInt(params['id']) : undefined)
  }

  submit(event: Event){
    if(this.formGroup.valid){
    }
  }
}
