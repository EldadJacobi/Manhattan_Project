
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class BankService {

  bankListFromServer: Array<any>;
  selected;
  dictionary;

  constructor(private http: HttpClient) {

    this.noBankWasSelected();

    this.getListOfBanksFromServer().subscribe(data => {
      this.bankListFromServer = data;
    });
  }

  getListOfBanksFromServer(): Observable<any> {
    return this.http.get('//localhost:8080/banks');
  }

  // goes here when you choose a bank from the list
  onSelected(bankName: string) {
    if (bankName.match('Select Bank') === null) {
      this.selected = 'Selected Bank: ' + bankName;
      this.getBankDictionary(bankName);
    } else {
      this.noBankWasSelected();
    }
  }

  /**
   * change the value of selected variable when no bank was selected.
   */
  noBankWasSelected() {
    this.selected = 'No Bank was selected yet...';
  }

  getBankDictionary(bank: string) {
    for (let i = 0; i < this.bankListFromServer.length; i++) {
      console.log(this.bankListFromServer[i]);
    }
  }

}
