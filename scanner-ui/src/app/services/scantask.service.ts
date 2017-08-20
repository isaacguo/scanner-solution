import {Constants} from "../common/constants";
import {Observable} from "rxjs/Rx";
import {Http, Response} from '@angular/http';
import {Injectable} from "@angular/core";
import {ScanTask} from "../models/scantask.model";
import {AbstractService} from "./abstract.service";
import {ScanTaskStatusEnum} from "../enums/scantaskstatus.enum";

@Injectable()
export class ScanTaskService extends AbstractService{

  constructor(private http: Http) {
    super();
  }

  getScanTasks(): Observable<ScanTask[]> {
    return this.http.get('/scannerdata/scantasks').map(this.extractData).catch(this.handleError);
  }

  getScanTaskByStatus(status:ScanTaskStatusEnum): Observable<ScanTask[]> {
    var statusString=ScanTaskStatusEnum[status];
    return this.http.get(`/scannerdata/scantasks/bystatus/${statusString}/`).map(this.extractData).catch(this.handleError);
  }

}
