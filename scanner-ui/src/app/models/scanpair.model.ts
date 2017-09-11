
import {ScanTask} from "./scantask.model";
import { ScanItem } from "./scanitem.model";

export class ScanPair
{
  constructor(
    public uuid?:string,
    public imagePath?:string,
    public imageName?:string,
    public scanItems?:ScanItem[],
    public scanTask?:ScanTask,
    public id?:number ){}

}
