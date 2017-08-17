import {Constants} from "../common/constants";
import {Observable} from "rxjs/Rx";
import {Http, Response} from '@angular/http';
import {Injectable} from "@angular/core";

@Injectable()
export class UploadService {

  private url = Constants.SCANNER_PROCESSOR_URL;

  constructor(private http: Http) {
  }


  initiateUploading(): Observable<any> {
    return this.http.post("/scannerprocessor/upload/initiateUploading", "").map(this.extractData).catch(this.handleError);
  }

  finishUploading(scanid: string): Observable<any> {
    return this.http.post(`/scannerprocessor/upload/finishUploading/${scanid}/`,null).map(this.extractData).catch(this.handleError);
  }


  getInfo(): Observable<string> {
    return this.http.get('/scannerdata').map(this.extractData).catch(this.handleError);
  }

  private extractData(res: Response) {
    let body = res.json();
    console.log(body);
    return body || {};
  }

  private handleError(error: Response | any) {
    // In a real world app, we might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
