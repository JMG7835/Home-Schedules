import { IUser } from './../interfaces/user.interface';

export interface ISchedule{
  id?: number | undefined;
  title: string;
  description: string;
  location: string;
  startDate: string;
  endDate: string;
  status: string;
  user: IUser;
  additionalUsers: IUser[];
}