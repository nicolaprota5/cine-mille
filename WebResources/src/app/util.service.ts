import { Injectable } from '@angular/core';
import { weekdays } from 'moment';

@Injectable({
  providedIn: 'root'
})
export class UtilService {

  constructor() { }


  public getWeekFromWeekInput(weekInput: string): number {

    if (!weekInput) {
      return -1;
    }

    const value: string[] = weekInput.split("W");

    return Number(value[1]);

  }

}
