import {Constants} from "../common/constants";
import {Observable} from "rxjs/Rx";
import {Http, Response} from '@angular/http';
import {Injectable} from "@angular/core";
import {AbstractService} from "./abstract.service";

@Injectable()
export class ImageService extends AbstractService {


  getImage(uuid: string, imageName: string): Observable<any> {
    return this.http.get(`/scannerprocessor/images/${uuid}/${imageName}/`).map(this.extractData).catch(this.handleError);
  }

  constructor(private http: Http) {
    super();
  }
}
