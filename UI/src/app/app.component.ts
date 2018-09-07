import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  bankListFromServer: Array<any>;
  selected;
  dictionary;
  dictionaryName;
  dictionaryVersion;

  constructor(private http: HttpClient) {
    this.noBankWasSelected();

    this.getListOfBanks().subscribe(data => {
      this.bankListFromServer = data;
    });
  }

  getListOfBanks(): Observable<any> {
    return this.http.get('//localhost:8080/banks');
  }

  /** when a bank is selected from a list we would like to bring its
   * dictionary details and update
   * @param bank - the selected bank from the drop down
   */
  onSelected(bank) {
    if (bank.name.match('Select Bank') === null) {
      this.selected = 'Selected Bank: ' + bank.name;
      this.dictionaryName = bank.dictionary.name;
      this.dictionaryVersion = bank.dictionary.version;

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
}

