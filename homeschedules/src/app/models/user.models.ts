import { IUser } from "../interfaces/user.interface";

export class User implements IUser{
  id?: number | undefined;
  name: string = "toto" ;
  email: string = "toto" ;
  phone: string = "toto";
  address: string = "toto";
  city: string = "toto" ;
  zip: string = "tota";

  static fromJson(userJson: IUser): User{
    return Object.assign(new User(), userJson);
  }

  toJson(): IUser{
    const userJson: IUser = Object.assign({}, this);
    delete userJson.id;
    return userJson;
  }
}
