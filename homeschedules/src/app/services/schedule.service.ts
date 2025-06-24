import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Schedule } from '../models/schedule.models';
import{ ISchedule } from '../interfaces/schedule.interface';
import { map, Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ScheduleService {
  private BASE_URL = 'http://localhost:8080/api/schedule';
  private http = inject(HttpClient);

 getAll(): Observable<Schedule[]> {
    return this.http.get<ISchedule[]>(this.BASE_URL).pipe(
      map(scheduleArray => {
        return scheduleArray.map<Schedule>(
          scheduleArray => Schedule.fromJson(scheduleArray)
        )
      })
    );
  }
}
