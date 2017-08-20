
import {ScanTaskStatusEnum} from "../enums/scantaskstatus.enum";
import {ScanPair} from "./scanpair.model";

export class ScanTask
{
  constructor(
    public uuid?:string,
    public name?:string,
    public status?:ScanTaskStatusEnum,
    public scanPairList?:ScanPair[],
    public id?:number ){}

}
