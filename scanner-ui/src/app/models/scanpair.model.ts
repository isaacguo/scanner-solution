
import {ScanTask} from "./scantask.model";

export class ScanPair
{
  constructor(
    public uuid?:string,
    public imagePath?:string,
    public imageName?:string,
    public text?:string,
    public scanTask?:ScanTask,
    public id?:number ){}

}
