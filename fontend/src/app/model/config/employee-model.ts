import { AuditAbleModel } from "../super-model/audit-able-model";

export interface Employee extends AuditAbleModel {
    firstName?:string;
    lastName?:string;
    birthDate?:Date;
    address?:string;
    email?:string;
    phoneNumber?:string;
    hireDate?:Date;
    position?:string;
    salary?:number;
}