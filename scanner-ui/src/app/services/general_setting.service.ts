import {Constants} from "../common/constants";
import {Observable} from "rxjs/Rx";
import {Http, Response} from '@angular/http';
import {Injectable} from "@angular/core";
import {AbstractService} from "./abstract.service";
import { GeneralSetting } from "../models/general_setting.model";

@Injectable()
export class GeneralSettingService extends AbstractService {


  getSettings(): Observable<GeneralSetting> {
    return this.http.get(`/scannerdata/general-settings`).map(this.extractData).catch(this.handleError);
  }

  constructor(private http: Http) {
    super();
  }
}
