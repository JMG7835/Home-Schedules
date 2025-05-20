import {ChangeDetectionStrategy, Component, inject, signal, OnInit} from '@angular/core';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatCardModule} from '@angular/material/card';
import {MatChipsModule} from '@angular/material/chips';
import { ActivatedRoute } from '@angular/router';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';

@Component({
  selector: 'app-user',
  imports: [MatCardModule, MatChipsModule, MatProgressBarModule, MatFormFieldModule],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class UserComponent implements OnInit{

  private route = inject(ActivatedRoute);
  userId = signal<number | undefined>(undefined);
  name = new FormControl('');

  ngOnInit(): void {
    const params = this.route.snapshot.params;
    this.userId.set(params['id'] ? parseInt(params['id']) : undefined)
  }

  submit(event: Event){

  }
}
