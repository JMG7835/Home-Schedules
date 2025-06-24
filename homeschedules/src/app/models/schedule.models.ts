import { IUser } from './../interfaces/user.interface';
import { ISchedule } from "../interfaces/schedule.interface";
import { User } from './user.models';

export class Schedule implements ISchedule{
  id?: number | undefined;
  title: string = "toto" ;
  description: string = "toto" ;
  location: string = "toto";
  startDate: string = "toto";
  endDate: string = "toto" ;
  status: string = "tota";
  user: IUser = new User;
  additionalUsers: IUser[] = [];

  static fromJson(userJson: ISchedule): Schedule{
    return Object.assign(new Schedule(), userJson);
  }

  toJson(): ISchedule{
    const scheduleJson: ISchedule = Object.assign({}, this);
    delete scheduleJson.id;
    return scheduleJson;
  }
}
