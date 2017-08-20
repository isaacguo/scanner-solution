import {Component, OnInit} from '@angular/core';
import {ScanTaskService} from "../../../services/scantask.service";
import {ScanTask} from "../../../models/scantask.model";
import {ScanTaskStatusEnum} from "../../../enums/scantaskstatus.enum";

@Component({
  selector: 'app-scanning-queue',
  templateUrl: './scanning-queue.component.html',
  styleUrls: ['./scanning-queue.component.css']
})
export class ScanningQueueComponent implements OnInit {

  scanTasks: ScanTask[];

  constructor(private scanTaskService: ScanTaskService) {
  }

  ngOnInit() {
    //this.scanTaskService.getScanTasks().subscribe(r => this.scanTasks = r);
    this.scanTaskService.getScanTaskByStatus(ScanTaskStatusEnum.UPLOADED).subscribe(r => this.scanTasks = r);
  }



}
